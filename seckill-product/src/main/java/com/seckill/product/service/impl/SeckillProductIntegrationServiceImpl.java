package com.seckill.product.service.impl;

import com.seckill.common.bean.SeckillOrder;
import com.seckill.common.bean.SeckillProduct;
import com.seckill.common.bean.SeckillUserResult;
import com.seckill.common.constant.SeckillGeneralCodeMapping;
import com.seckill.product.entity.SeckillUnique;
import com.seckill.product.service.SeckillProductIntegrationService;
import com.seckill.product.util.RedissonLockUtil;
import org.redisson.api.RLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

@Service
public class SeckillProductIntegrationServiceImpl implements SeckillProductIntegrationService {

    private static Logger logger = LoggerFactory.getLogger(SeckillProductIntegrationServiceImpl.class);
    private static Object objectLock = new Object();
    private Map<SeckillUnique, Future> seckillProductFutureMap = new HashMap<>(16);
    private ExecutorService executorService = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

    @Autowired
    private SeckillProductServiceImpl seckillProductService;
    @Autowired
    private SeckillUserResultServiceImpl seckillUserResultService;
    @Autowired
    private RedissonLockUtil redissonLockUtil;

    @Override
    public Map<SeckillUnique, Future> seckillProductDistributeFuture(SeckillProduct seckillProduct, SeckillOrder seckillOrder, SeckillUserResult seckillUserResult) {
        logger.info("seckillProductDistributeFuture入参seckillProduct：{} seckillOrder：{} seckillUserResult：{}", seckillProduct, seckillOrder, seckillUserResult);
        SeckillFuture seckillFuture = new SeckillFuture(seckillProduct, seckillOrder, seckillUserResult);
        Future<Integer> result = executorService.submit(seckillFuture);
        SeckillUnique seckillUnique = new SeckillUnique(seckillUserResult.getUserId(), seckillProduct.getId());
        seckillProductFutureMap.put(seckillUnique, result);
        return seckillProductFutureMap;
    }

    class SeckillFuture implements Callable {

        private SeckillProduct seckillProduct;

        private SeckillOrder seckillOrder;

        private SeckillUserResult seckillUserResult;

        public SeckillFuture() {
        }

        public SeckillFuture(SeckillProduct seckillProduct, SeckillOrder seckillOrder, SeckillUserResult seckillUserResult) {
            this.seckillProduct = seckillProduct;
            this.seckillOrder = seckillOrder;
            this.seckillUserResult = seckillUserResult;
        }

        public SeckillProduct getSeckillProduct() {
            return seckillProduct;
        }

        public void setSeckillProduct(SeckillProduct seckillProduct) {
            this.seckillProduct = seckillProduct;
        }

        public SeckillOrder getSeckillOrder() {
            return seckillOrder;
        }

        public void setSeckillOrder(SeckillOrder seckillOrder) {
            this.seckillOrder = seckillOrder;
        }

        public SeckillUserResult getSeckillUserResult() {
            return seckillUserResult;
        }

        public void setSeckillUserResult(SeckillUserResult seckillUserResult) {
            this.seckillUserResult = seckillUserResult;
        }

        /**
         * 成功返回0，失败返回1
         * @return
         * @throws Exception
         */
        @Override
        public Integer call() throws Exception {

            RLock rLock = redissonLockUtil.getFairLock(SeckillGeneralCodeMapping.REDISSON_SECKILL_PRODUCT_LOCK + "_" + seckillProduct.getId());
            Boolean lockResult = redissonLockUtil.tryLock(rLock, RedissonLockUtil.WAIT_LOCK_TIME, RedissonLockUtil.LOCK_TIME, TimeUnit.SECONDS);
            try {
                if (lockResult) {
                    Long seckillInventory = seckillProduct.getSeckillInventory();
                    Long seckillNum = seckillProduct.getSeckillNum();
                    Long seckillProductId = seckillProduct.getId();
                    Long userId = seckillOrder.getUserId();

                    seckillUserResult.setProductId(seckillProduct.getProductId());
                    seckillUserResult.setSeckillProductId(seckillProduct.getId());
                    //正在生成订单状态
                    seckillUserResult.setResult(2);
                    seckillUserResult.setResultData("用户" + userId + "正在秒杀生成订单");
                    seckillUserResult.setSeckillTime(new Date());
                    logger.info("用户{}开始SeckillFuture秒杀{}", userId, seckillProductId);
                    if (seckillNum > seckillInventory) {
                        logger.info("商品{}库存{}不足，秒杀数量为{}", seckillProductId, seckillInventory, seckillNum);
                        seckillUserResult.setResult(1);
                        seckillUserResult.setResultData("用户" + userId + "秒杀失败");
                    } else {
                        logger.info("用户{}秒杀商品{}成功，秒杀数量为{}", userId, seckillProductId, seckillNum);
                        seckillProduct.setId(seckillProductId);
                        seckillProduct.setSeckillInventory(seckillInventory - seckillNum);
                        seckillProductService.updateSeckillProductByPrimaryKeySelective(seckillProduct);
                    }
                    seckillUserResultService.saveSeckillUserResult(seckillUserResult);
                    return seckillUserResult.getResult();
                } else {
                    synchronized (objectLock) {
                        Long seckillProductId = seckillProduct.getId();
                        Long productId = seckillProduct.getProductId();
                        Long userId = seckillOrder.getUserId();
                        logger.error("用户{}秒杀商品{}加锁Redis失败", userId, seckillProductId);
                        seckillUserResult.setProductId(productId);
                        seckillUserResult.setSeckillProductId(seckillProductId);
                        seckillUserResult.setUserId(userId);
                        seckillUserResult.setResult(1);
                        seckillUserResult.setResultData("用户" + userId + "秒杀失败");
                        seckillUserResultService.saveSeckillUserResult(seckillUserResult);
                        return seckillUserResult.getResult();
                    }
                }
            } finally {
                redissonLockUtil.unlock(rLock);
            }
        }
    }
}

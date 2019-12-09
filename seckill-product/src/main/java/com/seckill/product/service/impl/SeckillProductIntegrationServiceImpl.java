package com.seckill.product.service.impl;

import com.seckill.common.bean.SeckillProduct;
import com.seckill.common.bean.SeckillUserResult;
import com.seckill.common.constant.SeckillGeneralCodeMapping;
import com.seckill.product.service.SeckillProductIntegrationService;
import com.seckill.product.util.RedissonLockUtil;
import org.redisson.api.RLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

public class SeckillProductIntegrationServiceImpl implements SeckillProductIntegrationService {

    private static Logger logger = LoggerFactory.getLogger(SeckillProductIntegrationServiceImpl.class);
    private static Object objectLock = new Object();
    private Map<String, Future> seckillProductFutureMap = new HashMap<>(16);
    private ExecutorService executorService = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

    @Autowired
    private SeckillProductServiceImpl seckillProductService;
    @Autowired
    private SeckillUserResultServiceImpl seckillUserResultService;
    @Autowired
    private RedissonLockUtil redissonLockUtil;

    @Override
    public void seckillProductDistributeFuture(Long userId, Long seckillProductId) {
        SeckillFuture seckillFuture = new SeckillFuture(userId, seckillProductId);
        Future<Integer> result = executorService.submit(seckillFuture);
        seckillProductFutureMap.put(userId + "_" + seckillProductId, result);
    }

    class SeckillFuture implements Callable {

        private Long userId;
        private Long seckillProductId;

        public SeckillFuture() {
        }

        public SeckillFuture(Long userId, Long seckillProductId) {
            this.userId = userId;
            this.seckillProductId = seckillProductId;
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public Long getSeckillProductId() {
            return seckillProductId;
        }

        public void setSeckillProductId(Long seckillProductId) {
            this.seckillProductId = seckillProductId;
        }

        /**
         * 成功返回0，失败返回1
         * @return
         * @throws Exception
         */
        @Override
        public Integer call() throws Exception {

            RLock rLock = redissonLockUtil.getFairLock(SeckillGeneralCodeMapping.REDISSON_SECKILL_PRODUCT_LOCK + "_" + seckillProductId);
            Boolean lockResult = redissonLockUtil.tryLock(rLock, RedissonLockUtil.WAIT_LOCK_TIME, RedissonLockUtil.LOCK_TIME, TimeUnit.SECONDS);
            try {
                if (lockResult) {
                    SeckillProduct seckillProduct = seckillProductService.findSeckillProductById(seckillProductId);
                    Long seckillInventory = seckillProduct.getSeckillInventory();
                    Long seckillNum = seckillProduct.getSeckillNum();

                    SeckillUserResult seckillUserResult = new SeckillUserResult();
                    seckillUserResult.setProductId(seckillProduct.getProductId());
                    seckillUserResult.setSeckillProductId(seckillProductId);
                    seckillUserResult.setUserId(userId);
                    seckillUserResult.setResult(0);
                    seckillUserResult.setResultData("用户" + userId + "秒杀成功");
                    seckillUserResult.setSeckillTime(new Date());
                    logger.info("用户{}开始SeckillFuture秒杀{}", userId, seckillProductId);
                    if (seckillNum > seckillInventory) {
                        logger.error("商品{}库存{}不足，秒杀数量为{}", seckillProductId, seckillInventory, seckillNum);
                        seckillUserResult.setResult(1);
                        seckillUserResult.setResultData("用户" + userId + "秒杀失败");
                    } else {
                        logger.error("用户{}秒杀商品{}成功，秒杀数量为{}", userId, seckillProductId, seckillNum);
                        SeckillProduct seckillProductNew = new SeckillProduct();
                        seckillProductNew.setId(seckillProductId);
                        seckillProductNew.setSeckillInventory(seckillInventory - seckillNum);
                        seckillProductService.updateSeckillProductByPrimaryKeySelective(seckillProductNew);
                    }
                    seckillUserResultService.saveSeckillUserResult(seckillUserResult);
                    return seckillUserResult.getResult();
                } else {
                    synchronized (objectLock) {
                        logger.error("用户{}秒杀商品{}加锁Redis失败", userId, seckillProductId);
                        SeckillProduct seckillProduct = seckillProductService.findSeckillProductById(seckillProductId);
                        SeckillUserResult seckillUserResult = new SeckillUserResult();
                        seckillUserResult.setProductId(seckillProduct.getProductId());
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

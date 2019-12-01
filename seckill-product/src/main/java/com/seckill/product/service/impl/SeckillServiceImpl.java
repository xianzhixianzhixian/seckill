package com.seckill.product.service.impl;

import com.seckill.common.bean.SeckillProduct;
import com.seckill.common.bean.SeckillProductExample;
import com.seckill.common.bean.SeckillUserResult;
import com.seckill.common.constant.SeckillNameMapping;
import com.seckill.product.service.SeckillService;
import com.seckill.product.service.SeckillProductFeignService;
import com.seckill.product.service.SeckillProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class SeckillServiceImpl implements SeckillService {

    private static final Logger logger = LoggerFactory.getLogger(SeckillServiceImpl.class);

    private Map<String, Long> cacheMap = new ConcurrentHashMap<>(16);

    @Autowired
    private SeckillProductService seckillProductService;
    @Autowired
    private SeckillProductFeignService seckillProductFeignService;
    @Autowired
    private SeckillUserResultServiceImpl seckillUserResultService;

    @Transactional
    @Override
    public Integer seckillProductAOP(Long userId, Long seckillProductId) {
        logger.info("buySeckillProduct入参userId：{} seckillProductId：{}", userId, seckillProductId);
        Integer updateNum = 0;
        SeckillProduct seckillProduct = seckillProductService.findSeckillProductById(seckillProductId);
        Long seckillInventory = seckillProduct.getSeckillInventory();
        Long seckillNum = seckillProduct.getSeckillNum();
        //一次秒杀商品的数量根据数据库来定
        if (seckillNum > seckillInventory) {
            logger.info("商品库存{}，抢购数量{}，库存不足", seckillInventory, seckillNum);
            return updateNum;
        }
        SeckillProduct seckillProductResult = new SeckillProduct();
        seckillProductResult.setId(seckillProduct.getId());
        seckillProductResult.setSeckillNum(seckillNum);
        seckillProductResult.setSeckillInventory(seckillInventory - seckillNum);
        updateNum = seckillProductService.updateSeckillProductByPrimaryKeySelective(seckillProductResult);
        return updateNum;
    }

    @Override
    public void multipltThreadSeckillProduct(Long userId, Long seckillProductId) {
        Long seckillInventory = cacheMap.get(SeckillNameMapping.SECKILLINVENTORY + "_" + seckillProductId);
        if (seckillInventory == null) {
            SeckillProduct seckillProduct = seckillProductService.findSeckillProductById(seckillProductId);
            cacheMap.put(SeckillNameMapping.SECKILLINVENTORY + "_" + seckillProductId, seckillProduct.getSeckillInventory());
            cacheMap.put(SeckillNameMapping.SECKILLNUM + "_" + seckillProductId, seckillProduct.getSeckillNum());
        }
        seckillInventory = cacheMap.get(SeckillNameMapping.SECKILLINVENTORY + "_" + seckillProductId);
        Long seckillNum = cacheMap.get(SeckillNameMapping.SECKILLNUM + "_" + seckillProductId);
        SeckillThread seckillThread = new SeckillThread(userId, seckillNum, seckillInventory, seckillProductId);
        Thread thread = new Thread(seckillThread);
        thread.start();
    }

    @Override
    public Integer seckillProductPessimisticLock(Long userId, Long seckillProductId) {
        Integer seckillResultNum = 0;
        SeckillProduct seckillProduct = seckillProductService.findSeckillProductByIdForUpdate(seckillProductId);
        Long seckillInventory = seckillProduct.getSeckillInventory();
        Long seckillNum = seckillProduct.getSeckillNum();
        if (seckillNum > seckillInventory) {
            return seckillResultNum;
        }
        SeckillProduct seckillProductUpdate = new SeckillProduct();
        seckillProductUpdate.setId(seckillProductId);
        seckillProductUpdate.setSeckillInventory(seckillInventory - seckillNum);
        seckillResultNum = seckillProductService.updateSeckillProductByPrimaryKeySelective(seckillProductUpdate);
        return seckillResultNum;
    }

    @Override
    public Integer seckillProductOptimisticLock(Long userId, Long seckillProductId) {
        Integer seckillResultNum = 0;
        SeckillProduct seckillProduct = seckillProductService.findSeckillProductById(seckillProductId);
        Long seckillInventory = seckillProduct.getSeckillInventory();
        Long seckillNum = seckillProduct.getSeckillNum();
        if (seckillNum > seckillInventory) {
            return seckillResultNum;
        }
        Integer seckillVersion = seckillProduct.getSeckillVersion();
        Integer seckillVersionNew = seckillVersion + 1;
        SeckillProduct seckillProductUpdate = new SeckillProduct();
        seckillProductUpdate.setId(seckillProductId);
        seckillProductUpdate.setSeckillInventory(seckillInventory - seckillNum);
        seckillProductUpdate.setSeckillVersion(seckillVersionNew);
        SeckillProductExample example = new SeckillProductExample();
        SeckillProductExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(seckillProductId);
        criteria.andSeckillVersionEqualTo(seckillVersion);
        seckillResultNum = seckillProductService.updateSeckillProductByExampleSelective(seckillProductUpdate, example);
        return seckillResultNum;
    }

    class SeckillThread implements Runnable {

        private Long userId;
        private Long seckillNum;
        private Long inventory;
        private Long seckillProductId;
        private Map<String, Long> cacheMap;

        public SeckillThread() {
        }

        public SeckillThread(Long userId, Long seckillNum, Long inventory, Long seckillProductId) {
            this.userId = userId;
            this.seckillNum = seckillNum;
            this.inventory = inventory;
            this.seckillProductId = seckillProductId;
            this.cacheMap = new ConcurrentHashMap<>();
        }

        @Override
        public void run() {
            SeckillUserResult seckillUserResult = new SeckillUserResult();
            SeckillProduct seckillProduct = seckillProductService.findSeckillProductById(seckillProductId);
            seckillUserResult.setProductId(seckillProduct.getProductId());
            seckillUserResult.setSeckillProductId(seckillProductId);
            seckillUserResult.setUserId(userId);
            seckillUserResult.setResult(0);
            seckillUserResult.setResultData("用户" + userId + "秒杀成功");
            seckillUserResult.setSeckillTime(new Date());
            logger.info("======线程{} 用户 {}开始秒杀======", Thread.currentThread().getName(), userId);
            if (seckillNum > inventory) {
                logger.info("线程{} 用户 {}秒杀商品库存不足", Thread.currentThread().getName(), userId);
                seckillUserResult.setResult(0);
                seckillUserResult.setResultData("用户" + userId + "秒杀失败");
            }
            seckillUserResultService.saveSeckillUserResult(seckillUserResult);
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public Long getSeckillNum() {
            return seckillNum;
        }

        public void setSeckillNum(Long seckillNum) {
            this.seckillNum = seckillNum;
        }

        public Long getInventory() {
            return inventory;
        }

        public void setInventory(Long inventory) {
            this.inventory = inventory;
        }

        public Long getProductId() {
            return seckillProductId;
        }

        public void setProductId(Long seckillProductId) {
            this.seckillProductId = seckillProductId;
        }

    }
}
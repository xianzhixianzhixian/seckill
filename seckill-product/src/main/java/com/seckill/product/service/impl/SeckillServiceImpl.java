package com.seckill.product.service.impl;

import com.seckill.common.bean.SeckillProduct;
import com.seckill.product.service.SeckillService;
import com.seckill.product.service.SeckillProductFeignService;
import com.seckill.product.service.SeckillProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class SeckillServiceImpl implements SeckillService {

    private static final Logger logger = LoggerFactory.getLogger(SeckillServiceImpl.class);

    private Lock lock = new ReentrantLock();

    @Autowired
    private SeckillProductService seckillProductService;
    @Autowired
    private SeckillProductFeignService seckillProductFeignService;

    @Transactional
    @Override
    public Integer buySeckillProduct(Long userId, Long id) throws Exception {
        lock.lock();
        logger.info("buySeckillProduct入参userId：{} id：{}", userId, id);
        Integer updateNum = 0;
        try {
            SeckillProduct seckillProduct = seckillProductService.findSeckillProductById(id);
            Long seckillInventory = seckillProduct.getSeckillInventory();
            Long seckillNum = seckillProduct.getSeckillNum();
            //默认秒杀一件商品
            seckillNum++;
            if (seckillNum < 0) {
                logger.error("秒杀商品数量{}小于0", seckillNum);
                return updateNum;
            }
            if (seckillNum > seckillInventory) {
                logger.info("商品库存{}，抢购数量{}，库存不足", seckillInventory, seckillNum);
                return updateNum;
            }
            SeckillProduct seckillProductResult = new SeckillProduct();
            seckillProductResult.setId(seckillProduct.getId());
            seckillProductResult.setSeckillNum(seckillNum);
            seckillProductResult.setSeckillInventory(seckillInventory - seckillNum);
            updateNum = seckillProductService.updateSeckillProductInfoSelective(seckillProductResult);
        } catch (Exception e) {
            logger.error("buySeckillProduct错误，原因{}", e);
            throw e;
        } finally {
            lock.unlock();
        }
        return updateNum;
    }
}

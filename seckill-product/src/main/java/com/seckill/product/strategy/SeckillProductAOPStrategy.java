package com.seckill.product.strategy;

import com.seckill.product.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SeckillProductAOPStrategy implements SeckillProductStrategy {

    private static final Logger logger = LoggerFactory.getLogger(SeckillProductAOPStrategy.class);

    private SeckillService seckillService;

    public SeckillProductAOPStrategy(SeckillService seckillService) {
        this.seckillService = seckillService;
    }

    @Override
    public Integer seckillProduct(Long userId, Long seckillProductId) {
        logger.info("seckillProduct AOP入参userId：{} seckillProductId：{}", userId, seckillProductId);
        return seckillService.seckillProductAOP(userId, seckillProductId);
    }

}

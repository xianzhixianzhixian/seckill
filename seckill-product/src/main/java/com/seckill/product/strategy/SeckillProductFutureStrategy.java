package com.seckill.product.strategy;

import com.seckill.product.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SeckillProductFutureStrategy implements SeckillProductStrategy {

    private static final Logger logger = LoggerFactory.getLogger(SeckillProductAOPStrategy.class);

    private SeckillService seckillService;

    public SeckillProductFutureStrategy(SeckillService seckillService) {
        this.seckillService = seckillService;
    }

    @Override
    public Integer seckillProduct(Long userId, Long seckillProductId) {
        logger.info("seckillProduct Future入参userId：{} seckillProductId：{}", userId, seckillProductId);
        seckillService.seckillProductFutrue(userId, seckillProductId);
        return 1;
    }
}

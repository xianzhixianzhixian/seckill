package com.seckill.product.strategy;

import com.seckill.product.service.SeckillProductIntegrationService;
import com.seckill.product.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SeckillProductFutureStrategy implements SeckillProductStrategy {

    private static final Logger logger = LoggerFactory.getLogger(SeckillProductAOPStrategy.class);

    private SeckillProductIntegrationService seckillProductIntegrationService;

    public SeckillProductFutureStrategy(SeckillProductIntegrationService seckillProductIntegrationService) {
        this.seckillProductIntegrationService = seckillProductIntegrationService;
    }

    @Override
    public Integer seckillProduct(Long userId, Long seckillProductId) {
        logger.info("seckillProduct Future入参userId：{} seckillProductId：{}", userId, seckillProductId);
        try {
            seckillProductIntegrationService.seckillProductDistributeFuture(userId, seckillProductId);
            return 1;
        } catch (Exception e) {
            logger.info("seckillProduct Future发生错误，原因{}", e);
            return 0;
        }
    }
}

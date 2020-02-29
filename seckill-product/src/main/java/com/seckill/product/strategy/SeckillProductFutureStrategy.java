package com.seckill.product.strategy;

import com.seckill.product.entity.SeckillUnique;
import com.seckill.product.service.SeckillProductIntegrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.Future;

public class SeckillProductFutureStrategy implements SeckillProductStrategy {

    private static final Logger logger = LoggerFactory.getLogger(SeckillProductAOPStrategy.class);

    private SeckillProductIntegrationService seckillProductIntegrationService;

    public SeckillProductFutureStrategy(SeckillProductIntegrationService seckillProductIntegrationService) {
        this.seckillProductIntegrationService = seckillProductIntegrationService;
    }

    @Override
    public Integer seckillProduct(Long userId, Long shopId, Long seckillProductId) {
        logger.info("seckillProduct Future入参userId：{} seckillProductId：{}", userId, seckillProductId);
        try {
            SeckillUnique seckillUnique = new SeckillUnique(userId, seckillProductId);
            Map<SeckillUnique, Future> resultMap = seckillProductIntegrationService.seckillProductDistributeFuture(userId, shopId, seckillProductId);
            Future<Integer> result = resultMap.get(seckillUnique);
            return result.get();
        } catch (Exception e) {
            logger.info("seckillProduct Future发生错误，原因{}", e);
            return 1;
        }
    }
}

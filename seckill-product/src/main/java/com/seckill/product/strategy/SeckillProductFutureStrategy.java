package com.seckill.product.strategy;

import com.seckill.common.bean.SeckillOrder;
import com.seckill.common.bean.SeckillProduct;
import com.seckill.common.bean.SeckillUserResult;
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
    public Integer seckillProduct(SeckillProduct seckillProduct, SeckillOrder seckillOrder, SeckillUserResult seckillUserResult) {
        logger.info("seckillProduct Future入参seckillProduct：{} seckillOrder：{} seckillUserResult：{}", seckillProduct, seckillOrder, seckillUserResult);
        try {
            Long userId = seckillUserResult.getUserId();
            Long seckillProductId = seckillProduct.getId();
            SeckillUnique seckillUnique = new SeckillUnique(userId, seckillProductId);
            Map<SeckillUnique, Future> resultMap = seckillProductIntegrationService.seckillProductDistributeFuture(seckillProduct, seckillOrder, seckillUserResult);
            Future<Integer> result = resultMap.get(seckillUnique);
            return result.get();
        } catch (Exception e) {
            logger.info("seckillProduct Future发生错误，原因{}", e);
            return 1;
        }
    }
}

package com.seckill.product.service;

import com.seckill.product.entity.SeckillUnique;

import java.util.Map;
import java.util.concurrent.Future;

/**
 * 秒杀整合Service
 */
public interface SeckillProductIntegrationService {

    /**
     * 分布式锁结合Future实现秒杀
     * @param userId
     * @param shopId
     * @param seckillProductId
     * @return
     */
    Map<SeckillUnique, Future> seckillProductDistributeFuture(Long userId, Long shopId, Long seckillProductId);
}

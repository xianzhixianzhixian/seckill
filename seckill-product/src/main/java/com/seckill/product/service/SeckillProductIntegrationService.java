package com.seckill.product.service;

import com.seckill.common.bean.SeckillResult;

/**
 * 秒杀整合Service
 */
public interface SeckillProductIntegrationService {

    /**
     * 分布式锁结合Future实现秒杀
     * @param userId
     * @param seckillProductId
     */
    void seckillProductDistributeFuture(Long userId, Long seckillProductId);
}

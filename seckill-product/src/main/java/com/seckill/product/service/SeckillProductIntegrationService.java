package com.seckill.product.service;

import com.seckill.common.bean.SeckillOrder;
import com.seckill.common.bean.SeckillProduct;
import com.seckill.common.bean.SeckillUserResult;
import com.seckill.product.entity.SeckillUnique;

import java.util.Map;
import java.util.concurrent.Future;

/**
 * 秒杀整合Service
 */
public interface SeckillProductIntegrationService {

    /**
     * 分布式锁结合Future实现秒杀
     * @param seckillProduct
     * @param seckillOrder
     * @param seckillUserResult
     * @return
     */
    Map<SeckillUnique, Future> seckillProductDistributeFuture(SeckillProduct seckillProduct, SeckillOrder seckillOrder, SeckillUserResult seckillUserResult);
}

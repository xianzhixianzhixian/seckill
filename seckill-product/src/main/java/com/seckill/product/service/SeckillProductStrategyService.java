package com.seckill.product.service;

/**
 * 秒杀策略模式Service
 */
public interface SeckillProductStrategyService {

    /**
     * 设置Redis中秒杀商品的策略
     * @param strategyName
     * @return
     */
    String setSeckillProductStrategy(String strategyName, String strategyValue);
}

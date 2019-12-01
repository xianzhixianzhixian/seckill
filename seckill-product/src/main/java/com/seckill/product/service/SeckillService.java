package com.seckill.product.service;

/**
 * 秒杀服务Service
 */
public interface SeckillService {

    /**
     * 同步秒杀商品方法
     * @param userId
     * @param productId
     * @return
     */
    Integer seckillProductAOP(Long userId, Long productId);

    /**
     * 多线程异步处理秒杀
     * @param userId
     * @param id
     */
    void multipltThreadSeckillProduct(Long userId, Long id);

}

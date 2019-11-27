package com.seckill.product.service;

/**
 * 秒杀服务Service
 */
public interface SeckillService {

    /**
     * 秒杀程序锁
     * @param userId
     * @param productId
     * @return
     */
    Integer buySeckillProduct(Long userId, Long productId) throws Exception;
}

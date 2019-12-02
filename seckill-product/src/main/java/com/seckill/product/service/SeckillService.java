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

    /**
     * 悲观锁秒杀
     * @param userId
     * @param id
     * @return
     */
    Integer seckillProductPessimisticLock(Long userId, Long id);

    /**
     * 乐观锁秒杀商品
     * @param userId
     * @param id
     * @return
     */
    Integer seckillProductOptimisticLock(Long userId, Long id);

    /**
     * 使用队列和多线程进行秒杀
     * @param userId
     * @param seckillProductId
     */
    void seckillProductQueueAndThread(Long userId, Long seckillProductId);
}

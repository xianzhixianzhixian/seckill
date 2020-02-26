package com.seckill.product.service;

/**
 * 秒杀服务Service
 */
public interface SeckillService {

    /**
     * 同步AOP锁秒杀商品方法
     * @param userId
     * @param seckillProductId
     * @return
     */
    Integer seckillProductAOP(Long userId, Long seckillProductId);

    /**
     * 多线程异步处理秒杀
     * @param userId
     * @param seckillProductId
     */
    void multipltThreadSeckillProduct(Long userId, Long seckillProductId);

    /**
     * 悲观锁秒杀
     * @param userId
     * @param seckillProductId
     * @return
     */
    Integer seckillProductPessimisticLock(Long userId, Long seckillProductId);

    /**
     * 乐观锁秒杀商品
     * @param userId
     * @param seckillProductId
     * @return
     */
    Integer seckillProductOptimisticLock(Long userId, Long seckillProductId);

    /**
     * 使用队列和多线程进行秒杀
     * @param userId
     * @param seckillProductId
     */
    void seckillProductQueueAndThread(Long userId, Long seckillProductId);

    /**
     * 使用Redis分布式锁进行秒杀
     * @param userId
     * @param seckillProductId
     * @return
     */
    Integer seckillProductRedisLock(Long userId, Long seckillProductId);

    /**
     * 使用Future模式进行秒杀(这里会有问题，因为call()方法中的操作都是非原子性的，需要后续添加分布式锁)
     * @param userId
     * @param seckillProductId
     */
    void seckillProductFutrue(Long userId, Long seckillProductId);
}

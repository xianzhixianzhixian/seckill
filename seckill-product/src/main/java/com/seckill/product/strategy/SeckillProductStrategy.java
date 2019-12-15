package com.seckill.product.strategy;

/**
 * 秒杀商品的策略
 * @author xianzhixianzhixian on 20191215
 */
public interface SeckillProductStrategy {

    /**
     * 锁秒杀商品方法
     * 锁秒杀商品方法
     * @param userId
     * @param seckillProductId
     * @return
     */
    Integer seckillProduct(Long userId, Long seckillProductId);

}

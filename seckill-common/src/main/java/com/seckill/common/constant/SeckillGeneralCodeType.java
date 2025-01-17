package com.seckill.common.constant;

/**
 * 系统中一些常量的映射
 */
public class SeckillGeneralCodeType {

    /**
     * 秒杀商品库存
     */
    public static final String SECKILL_INVENTORY = "seckillInventory";

    /**
     * 秒杀商品数量
     */
    public static final String SECKILL_NUM = "seckillNum";

    /**
     * 秒杀商品的锁
     */
    public static final String REDISSON_SECKILL_PRODUCT_LOCK = "REDISSON_SECKILL_PRODUCT_LOCK";

    /**
     * Redis锁等待时间
     */
    public static final Long REDISSON_LOCK_WAIT_TIME = 30L;

    /**
     * Redis锁锁定时间
     */
    public static final Long REDISSON_LOCK_LOCK_TIME = 10L;

    /**
     * 秒杀策略模式
     */
    public static final String SECKILL_STRATEGY = "SECKILL_STRATEGY";

    /**
     * 秒杀策略模式AOP锁
     */
    public static final String SECKILL_STRATEGY_AOP_LOCK = "SECKILL_STRATEGY_AOP_LOCK";

    /**
     * 秒杀Future模式
     */
    public static final String SECKILL_STRATEGY_FUTURE = "SECKILL_STRATEGY_FUTURE";

}

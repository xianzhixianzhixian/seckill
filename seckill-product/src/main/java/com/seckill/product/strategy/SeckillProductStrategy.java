package com.seckill.product.strategy;

import com.seckill.common.bean.SeckillOrder;
import com.seckill.common.bean.SeckillProduct;
import com.seckill.common.bean.SeckillUserResult;

/**
 * 秒杀商品的策略
 * @author xianzhixianzhixian on 20191215
 */
public interface SeckillProductStrategy {

    /**
     * 锁秒杀商品方法
     * @param seckillProduct
     * @param seckillOrder
     * @param seckillUserResult
     * @return
     */
    Integer seckillProduct(SeckillProduct seckillProduct, SeckillOrder seckillOrder, SeckillUserResult seckillUserResult);

}

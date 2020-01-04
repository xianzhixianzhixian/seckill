package com.seckill.order.service;

import com.seckill.common.bean.SeckillOrder;

public interface SeckillOrderService {

    /**
     * 新建订单
     * @param seckillOrder
     * @return
     */
    Integer createNewOrder(SeckillOrder seckillOrder) throws Exception;
}

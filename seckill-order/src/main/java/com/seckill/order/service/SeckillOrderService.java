package com.seckill.order.service;

import com.seckill.common.bean.SeckillOrder;
import com.seckill.common.entity.OrderRequest;

public interface SeckillOrderService {

    /**
     * 新建订单
     * @param seckillOrder
     * @return
     */
    Integer createNewOrder(SeckillOrder seckillOrder) throws Exception;

    /**
     * 提供给message组件创建订单
     * @param orderRequest
     * @return
     * @throws Exception
     */
    Integer createNewOrder(OrderRequest orderRequest) throws Exception;
}

package com.seckill.order.service;

import com.seckill.common.bean.SeckillOrder;
import com.seckill.common.entity.OrderRequest;

import java.util.List;

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

    /**
     * 根据订单id查询订单信息
     * @param id
     * @return
     */
    SeckillOrder findSeckillOrderById(Long id);

    /**
     * 根据id更新订单信息
     * @param seckillOrder
     * @return
     */
    Integer updateSeckillOrderById(SeckillOrder seckillOrder);

    /**
     * 以当前时间为起点，查询timeSpan之前(包含)或之后(包含)状态为orderState的订单
     * @param timeType
     * @param timeSpan
     * @param payStatus
     * @param orderFlag
     * @return
     */
    List<SeckillOrder> listSeckillOrderByTime(Integer timeType , Integer timeSpan, Integer payStatus, Integer orderFlag);

}

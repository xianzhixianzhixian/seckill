package com.seckill.common.entity;

import com.seckill.common.bean.SeckillOrder;
import com.seckill.common.bean.SeckillProduct;
import com.seckill.common.bean.SeckillUserResult;

/**
 * 传入RabbitMQ的订单消息
 */
public class OrderRequest {

    private String eventName;

    private SeckillProduct seckillProduct;

    private SeckillOrder seckillOrder;

    private SeckillUserResult seckillUserResult;

    public OrderRequest() {
    }

    public OrderRequest(String eventName, SeckillProduct seckillProduct, SeckillOrder seckillOrder, SeckillUserResult seckillUserResult) {
        this.eventName = eventName;
        this.seckillProduct = seckillProduct;
        this.seckillOrder = seckillOrder;
        this.seckillUserResult = seckillUserResult;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public SeckillProduct getSeckillProduct() {
        return seckillProduct;
    }

    public void setSeckillProduct(SeckillProduct seckillProduct) {
        this.seckillProduct = seckillProduct;
    }

    public SeckillOrder getSeckillOrder() {
        return seckillOrder;
    }

    public void setSeckillOrder(SeckillOrder seckillOrder) {
        this.seckillOrder = seckillOrder;
    }

    public SeckillUserResult getSeckillUserResult() {
        return seckillUserResult;
    }

    public void setSeckillUserResult(SeckillUserResult seckillUserResult) {
        this.seckillUserResult = seckillUserResult;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "eventName='" + eventName + '\'' +
                ", seckillProduct=" + seckillProduct +
                ", seckillOrder=" + seckillOrder +
                ", seckillUserResult=" + seckillUserResult +
                '}';
    }
}

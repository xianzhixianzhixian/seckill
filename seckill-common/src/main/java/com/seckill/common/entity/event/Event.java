package com.seckill.common.entity.event;

import com.seckill.common.bean.SeckillOrder;
import com.seckill.common.bean.SeckillProduct;
import com.seckill.common.bean.SeckillUserResult;

public class Event {

    private String name;

    private String eventType;

    private SeckillProduct seckillProduct;

    private SeckillOrder seckillOrder;

    private SeckillUserResult seckillUserResult;

    public Event() {
    }

    public Event(
            String name,
            String eventType,
            SeckillProduct seckillProduct,
            SeckillOrder seckillOrder,
            SeckillUserResult seckillUserResult
    ) {
        this.name = name;
        this.eventType = eventType;
        this.seckillProduct = seckillProduct;
        this.seckillOrder = seckillOrder;
        this.seckillUserResult = seckillUserResult;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
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
        return "Event{" +
                "name='" + name + '\'' +
                ", eventType='" + eventType + '\'' +
                ", seckillProduct=" + seckillProduct +
                ", seckillOrder=" + seckillOrder +
                ", seckillUserResult=" + seckillUserResult +
                '}';
    }
}

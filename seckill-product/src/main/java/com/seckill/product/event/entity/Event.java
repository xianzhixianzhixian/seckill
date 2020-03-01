package com.seckill.product.event.entity;

import com.seckill.common.bean.SeckillOrder;
import com.seckill.common.bean.SeckillProduct;
import com.seckill.common.bean.SeckillUserResult;
import com.seckill.product.service.SeckillService;
import com.seckill.product.service.SeckillUserResultService;
import com.seckill.product.service.feign.SeckillMessageFeignService;
import com.seckill.product.strategy.SeckillProductStrategy;

public class Event {

    private String name;

    private String eventType;

    private SeckillProduct seckillProduct;

    private SeckillOrder seckillOrder;

    private SeckillUserResult seckillUserResult;

    private SeckillService seckillService;

    private SeckillUserResultService seckillUserResultService;

    private SeckillProductStrategy seckillProductStrategy;

    private SeckillMessageFeignService seckillMessageFeignService;

    public Event() {
    }

    public Event(
            String name,
            String eventType,
            SeckillProduct seckillProduct,
            SeckillOrder seckillOrder,
            SeckillUserResult seckillUserResult,
            SeckillService seckillService,
            SeckillUserResultService seckillUserResultService,
            SeckillProductStrategy seckillProductStrategy,
            SeckillMessageFeignService seckillMessageFeignService
    ) {
        this.name = name;
        this.eventType = eventType;
        this.seckillProduct = seckillProduct;
        this.seckillOrder = seckillOrder;
        this.seckillUserResult = seckillUserResult;
        this.seckillService = seckillService;
        this.seckillUserResultService = seckillUserResultService;
        this.seckillProductStrategy = seckillProductStrategy;
        this.seckillMessageFeignService = seckillMessageFeignService;
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

    public SeckillService getSeckillService() {
        return seckillService;
    }

    public void setSeckillService(SeckillService seckillService) {
        this.seckillService = seckillService;
    }

    public SeckillUserResultService getSeckillUserResultService() {
        return seckillUserResultService;
    }

    public void setSeckillUserResultService(SeckillUserResultService seckillUserResultService) {
        this.seckillUserResultService = seckillUserResultService;
    }

    public SeckillProductStrategy getSeckillProductStrategy() {
        return seckillProductStrategy;
    }

    public void setSeckillProductStrategy(SeckillProductStrategy seckillProductStrategy) {
        this.seckillProductStrategy = seckillProductStrategy;
    }

    public SeckillMessageFeignService getSeckillMessageFeignService() {
        return seckillMessageFeignService;
    }

    public void setSeckillMessageFeignService(SeckillMessageFeignService seckillMessageFeignService) {
        this.seckillMessageFeignService = seckillMessageFeignService;
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

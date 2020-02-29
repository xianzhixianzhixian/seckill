package com.seckill.product.event.entity;

import com.seckill.product.service.feign.SeckillMessageFeignService;

/**
 * 订单事件
 */
public class OrderEvent implements Event {

    private String name;

    private String eventType;

    private Long userId;

    private Long shopId;

    private Long seckillProductId;

    private SeckillMessageFeignService seckillMessageFeignService;

    public OrderEvent() {
    }

    public OrderEvent(
            String name,
            String eventType,
            Long userId,
            Long shopId,
            Long seckillProductId,
            SeckillMessageFeignService seckillMessageFeignService
    ) {
        this.name = name;
        this.eventType = eventType;
        this.userId = userId;
        this.shopId = shopId;
        this.seckillProductId = seckillProductId;
        this.seckillMessageFeignService = seckillMessageFeignService;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSeckillProductId() {
        return seckillProductId;
    }

    public void setSeckillProductId(Long seckillProductId) {
        this.seckillProductId = seckillProductId;
    }

    public SeckillMessageFeignService getSeckillMessageFeignService() {
        return seckillMessageFeignService;
    }

    public void setSeckillMessageFeignService(SeckillMessageFeignService seckillMessageFeignService) {
        this.seckillMessageFeignService = seckillMessageFeignService;
    }

    @Override
    public String toString() {
        return "OrderEvent{" +
                "name='" + name + '\'' +
                ", eventType='" + eventType + '\'' +
                ", userId=" + userId +
                ", shopId=" + shopId +
                ", seckillProductId=" + seckillProductId +
                '}';
    }
}

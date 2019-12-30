package com.seckill.product.event.entity;

/**
 * 订单事件
 */
public class OrderEvent implements Event {

    private String name;

    private String eventType;

    private Long userId;

    private Long seckillProductId;

    public OrderEvent() {
    }

    public OrderEvent(String name, String eventType) {
        this.name = name;
        this.eventType = eventType;
    }

    public OrderEvent(String name, String eventType, Long userId, Long seckillProductId) {
        this.name = name;
        this.eventType = eventType;
        this.userId = userId;
        this.seckillProductId = seckillProductId;
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

    @Override
    public String toString() {
        return "OrderEvent{" +
                "name='" + name + '\'' +
                ", eventType='" + eventType + '\'' +
                ", userId=" + userId +
                ", seckillProductId=" + seckillProductId +
                '}';
    }
}

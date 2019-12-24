package com.seckill.product.event.entity;

/**
 * 订单事件
 */
public class OrderEvent implements Event {

    private String name;

    private String eventType;

    public OrderEvent() {
    }

    public OrderEvent(String name, String eventType) {
        this.name = name;
        this.eventType = eventType;
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

    @Override
    public String toString() {
        return "OrderEvent{" +
                "name='" + name + '\'' +
                ", eventType='" + eventType + '\'' +
                '}';
    }
}

package com.seckill.product.event.entity;

/**
 * 秒杀事件
 */
public class SeckillProductEvent implements Event {

    private String name;

    private String eventType;

    public SeckillProductEvent() {
    }

    public SeckillProductEvent(String name, String eventType) {
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
        return "SeckillProductEvent{" +
                "name='" + name + '\'' +
                ", eventType='" + eventType + '\'' +
                '}';
    }
}

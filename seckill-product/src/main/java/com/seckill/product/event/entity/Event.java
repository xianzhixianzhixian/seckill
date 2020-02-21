package com.seckill.product.event.entity;

import com.seckill.product.service.SeckillMessageFeignService;

public interface Event {

    String getName();

    void setName(String name);

    String getEventType();

    void setEventType(String eventType);

    String toString();

    SeckillMessageFeignService getSeckillMessageFeignService();

    void setSeckillMessageFeignService(SeckillMessageFeignService seckillMessageFeignService);
}

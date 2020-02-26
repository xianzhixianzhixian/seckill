package com.seckill.product.event.entity;

import com.seckill.product.service.feign.SeckillMessageFeignService;

/**
 * 中央处理器转发事件
 */
public class CentralForwardEvent implements Event {
    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public String getEventType() {
        return null;
    }

    @Override
    public void setEventType(String eventType) {

    }

    @Override
    public SeckillMessageFeignService getSeckillMessageFeignService() {
        return null;
    }

    @Override
    public void setSeckillMessageFeignService(SeckillMessageFeignService seckillMessageFeignService) {

    }
}

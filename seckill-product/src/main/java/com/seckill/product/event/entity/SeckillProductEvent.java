package com.seckill.product.event.entity;

import com.seckill.product.service.SeckillMessageFeignService;
import com.seckill.product.service.SeckillService;

/**
 * 秒杀事件
 */
public class SeckillProductEvent implements Event {

    private String name;

    private String eventType;

    private Long userId;

    private Long seckillProductId;

    private SeckillService seckillService;

    private SeckillMessageFeignService seckillMessageFeignService;

    public SeckillProductEvent() {
    }

    public SeckillProductEvent(
            String name,
            String eventType,
            Long userId,
            Long seckillProductId,
            SeckillService seckillService,
            SeckillMessageFeignService seckillMessageFeignService
    ) {
        this.name = name;
        this.eventType = eventType;
        this.userId = userId;
        this.seckillProductId = seckillProductId;
        this.seckillService = seckillService;
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

    public SeckillService getSeckillService() {
        return seckillService;
    }

    public void setSeckillService(SeckillService seckillService) {
        this.seckillService = seckillService;
    }

    public SeckillMessageFeignService getSeckillMessageFeignService() {
        return seckillMessageFeignService;
    }

    public void setSeckillMessageFeignService(SeckillMessageFeignService seckillMessageFeignService) {
        this.seckillMessageFeignService = seckillMessageFeignService;
    }

    @Override
    public String toString() {
        return "SeckillProductEvent{" +
                "name='" + name + '\'' +
                ", eventType='" + eventType + '\'' +
                ", userId=" + userId +
                ", seckillProductId=" + seckillProductId +
                '}';
    }
}

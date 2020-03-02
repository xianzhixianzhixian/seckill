package com.seckill.product.event.entity;

import com.seckill.common.bean.SeckillOrder;
import com.seckill.common.bean.SeckillProduct;
import com.seckill.common.bean.SeckillUserResult;
import com.seckill.common.entity.event.Event;
import com.seckill.product.service.SeckillService;
import com.seckill.product.service.SeckillUserResultService;
import com.seckill.product.service.feign.SeckillMessageFeignService;
import com.seckill.product.strategy.SeckillProductStrategy;

/**
 * 订单事件
 */
public class OrderEvent extends Event {

    private SeckillService seckillService;

    private SeckillUserResultService seckillUserResultService;

    private SeckillProductStrategy seckillProductStrategy;

    private SeckillMessageFeignService seckillMessageFeignService;

    public OrderEvent() {
    }

    public OrderEvent(
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
        super(name, eventType, seckillProduct, seckillOrder, seckillUserResult);
        this.seckillService = seckillService;
        this.seckillUserResultService = seckillUserResultService;
        this.seckillProductStrategy = seckillProductStrategy;
        this.seckillMessageFeignService = seckillMessageFeignService;
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

}

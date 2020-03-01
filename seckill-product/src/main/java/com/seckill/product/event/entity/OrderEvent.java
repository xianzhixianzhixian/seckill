package com.seckill.product.event.entity;

import com.seckill.common.bean.SeckillOrder;
import com.seckill.common.bean.SeckillProduct;
import com.seckill.common.bean.SeckillUserResult;
import com.seckill.product.service.SeckillService;
import com.seckill.product.service.SeckillUserResultService;
import com.seckill.product.service.feign.SeckillMessageFeignService;
import com.seckill.product.strategy.SeckillProductStrategy;

/**
 * 订单事件
 */
public class OrderEvent extends Event {

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
        super(name, eventType, seckillProduct, seckillOrder, seckillUserResult, seckillService, seckillUserResultService, seckillProductStrategy, seckillMessageFeignService);
    }
}

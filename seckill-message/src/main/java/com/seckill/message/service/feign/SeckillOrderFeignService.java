package com.seckill.message.service.feign;

import com.seckill.common.bean.SeckillOrder;
import com.seckill.common.bean.SeckillResult;
import com.seckill.common.entity.OrderRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "seckill-order")
public interface SeckillOrderFeignService {

    @PostMapping("/order/createOrder")
    public SeckillResult createOrder(@RequestBody OrderRequest orderRequest);

    @PostMapping("/order/updateSeckillOrderById")
    public SeckillResult updateSeckillOrderById(@RequestBody SeckillOrder seckillOrder);

}

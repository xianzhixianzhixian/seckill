package com.seckill.task.service.feign;

import com.seckill.common.bean.SeckillOrder;
import com.seckill.common.bean.SeckillResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("seckill-order")
public interface SeckillOrderFeignService {

    @PostMapping("/order/listSeckillOrderByTime")
    public SeckillResult listSeckillOrderByTime(
            @RequestParam("timeType") Integer timeType,
            @RequestParam("timeSpan") Integer timeSpan,
            @RequestParam("payStatus") Integer payStatus,
            @RequestParam("orderFlag") Integer orderFlag
    );

    @PostMapping("/order/updateSeckillOrderById")
    public SeckillResult updateSeckillOrderById(SeckillOrder seckillOrder);

}

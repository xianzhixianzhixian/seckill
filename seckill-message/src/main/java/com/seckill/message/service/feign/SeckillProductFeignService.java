package com.seckill.message.service.feign;

import com.seckill.common.bean.SeckillResult;
import com.seckill.common.entity.event.Event;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("seckill-product")
public interface SeckillProductFeignService {

    @PostMapping("/seckill/sendEvent")
    public SeckillResult sendEvent(Event event);

}

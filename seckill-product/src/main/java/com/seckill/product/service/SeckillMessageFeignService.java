package com.seckill.product.service;

import com.seckill.common.entity.OrderRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "seckill-message")
public interface SeckillMessageFeignService {

    @PostMapping("/message/sendOrderMessage")
    public Boolean sendOrderMessage(@RequestBody OrderRequest orderRequest);
}

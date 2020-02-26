package com.seckill.order.service.feign;

import com.seckill.common.bean.SeckillProduct;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "seckill-product")
public interface SeckillProductFeignService {

    @PostMapping("/seckillProduct/findSeckillProductBySeckillProductId")
    public SeckillProduct findSeckillProductBySeckillProductId(@RequestParam("seckillProductId") Long seckillProductId);
}

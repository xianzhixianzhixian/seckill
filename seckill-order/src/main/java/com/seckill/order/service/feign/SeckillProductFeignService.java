package com.seckill.order.service.feign;

import com.seckill.common.bean.SeckillProduct;
import com.seckill.common.bean.SeckillResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.*;

@FeignClient(value = "seckill-product")
public interface SeckillProductFeignService {

    @PostMapping("/seckillProduct/findSeckillProductBySeckillProductId")
    public SeckillProduct findSeckillProductBySeckillProductId(@RequestParam("seckillProductId") Long seckillProductId);

}

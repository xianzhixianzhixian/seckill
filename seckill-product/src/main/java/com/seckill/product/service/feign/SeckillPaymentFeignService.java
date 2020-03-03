package com.seckill.product.service.feign;

import com.seckill.common.bean.SeckillResult;
import com.seckill.common.entity.PaymentParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("seckill-payment")
public interface SeckillPaymentFeignService {

    @PostMapping("/payment/payForOrder")
    public SeckillResult payForOrder(@RequestBody PaymentParam paymentParam);

}

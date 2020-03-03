package com.seckill.payment.controller;

import com.seckill.common.bean.SeckillResult;
import com.seckill.common.constant.PaymentType;
import com.seckill.common.constant.SeckillReturnCodeType;
import com.seckill.common.entity.PaymentParam;
import com.seckill.payment.service.impl.SeckillPaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/payment")
@RestController
public class SeckillPaymentController {

    @Autowired
    private SeckillPaymentServiceImpl seckillPaymentService;

    @PostMapping("/payForOrder")
    public SeckillResult payForOrder(@RequestBody PaymentParam paymentParam) {
        try {
            if (PaymentType.ALI_PAY.equals(paymentParam.getPaymentType())) {
                seckillPaymentService.payWithAlipay(paymentParam);
            } else if (PaymentType.WECHAT_PAY.equals(paymentParam.getPaymentType())) {
                seckillPaymentService.payWithWechat(paymentParam);
            } else if (PaymentType.UNION_PAY.equals(paymentParam.getPaymentType())) {
                seckillPaymentService.payWithUnionPay(paymentParam);
            }
            return new SeckillResult(SeckillReturnCodeType.SUCCESS_CODE, "付款成功");
        } catch (Exception e) {
            return new SeckillResult(SeckillReturnCodeType.SYSTEM_ERROR, "付款失败", e);
        }

    }

}

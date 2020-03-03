package com.seckill.payment.service.impl;

import com.seckill.common.entity.PaymentParam;
import com.seckill.payment.service.SeckillPaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SeckillPaymentServiceImpl implements SeckillPaymentService {

    private static final Logger logger = LoggerFactory.getLogger(SeckillPaymentServiceImpl.class);

    @Override
    public void payWithAlipay(PaymentParam alipayParam) {
        logger.info("payWithAlipay接收到参数{}", alipayParam);
    }

    @Override
    public void payWithWechat(PaymentParam wechatPayParam) {
        logger.info("payWithWechat接收到参数{}", wechatPayParam);
    }

    @Override
    public void payWithUnionPay(PaymentParam unionPayParam) {
        logger.info("payWithUnionPay接收到参数{}", unionPayParam);
    }
}

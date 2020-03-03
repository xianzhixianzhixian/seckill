package com.seckill.payment.service;

import com.seckill.common.entity.PaymentParam;

/**
 * 支付Service
 * @author xianzhixianzhixian
 * @date 2020/03/03 22:13
 */
public interface SeckillPaymentService {

    /**
     * 支付宝付款
     * @param alipayParam
     */
    void payWithAlipay(PaymentParam alipayParam);

    /**
     * 微信付款
     * @param wechatPayParam
     */
    void payWithWechat(PaymentParam wechatPayParam);

    /**
     * 银联付款
     * @param unionPayParam
     */
    void payWithUnionPay(PaymentParam unionPayParam);

}

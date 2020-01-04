package com.seckill.order.controller;

import com.seckill.common.bean.SeckillOrder;
import com.seckill.common.bean.SeckillResult;
import com.seckill.common.constant.SeckillReturnCodeMapping;
import com.seckill.order.service.impl.SeckillOrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/order")
@RestController
public class SeckillOrderController {

    @Autowired
    private SeckillOrderServiceImpl seckillOrderService;

    @PostMapping("/createNewOrder")
    public SeckillResult createNewOrder(@RequestBody SeckillOrder seckillOrder) {
        Integer resultNum = 0;
        try {
            resultNum = seckillOrderService.createNewOrder(seckillOrder);
            if (resultNum > 0) {
                return new SeckillResult(SeckillReturnCodeMapping.SUCCESS_CODE, "订单创建成功！");
            } else {
                return new SeckillResult(SeckillReturnCodeMapping.BUSINESS_FAIL, "订单创建失败！");
            }
        } catch (Exception e) {
            return new SeckillResult(SeckillReturnCodeMapping.SYSTEM_ERROR, e.getMessage());
        }
    }
}

package com.seckill.order.controller;

import com.seckill.common.bean.SeckillOrder;
import com.seckill.common.bean.SeckillResult;
import com.seckill.common.constant.SeckillReturnCodeMapping;
import com.seckill.common.entity.OrderRequest;
import com.seckill.common.utils.JsonUtils;
import com.seckill.order.service.feign.SeckillProductFeignService;
import com.seckill.order.service.impl.SeckillOrderServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/order")
@RestController
public class SeckillOrderController {

    private static final Logger logger = LoggerFactory.getLogger(SeckillOrderController.class);

    @Autowired
    private SeckillOrderServiceImpl seckillOrderService;
    @Autowired
    private SeckillProductFeignService seckillProductFeignService;

    @PostMapping("/createNewOrder")
    public SeckillResult createNewOrder(@RequestBody SeckillOrder seckillOrder) {
        logger.info("createNewOrder接收到订单创建请求{}", seckillOrder);
        try {
            Integer resultNum = seckillOrderService.createNewOrder(seckillOrder);
            if (resultNum > 0) {
                return new SeckillResult(SeckillReturnCodeMapping.SUCCESS_CODE, "订单创建成功！", seckillOrder);
            } else {
                return new SeckillResult(SeckillReturnCodeMapping.BUSINESS_FAIL, "订单创建失败！");
            }
        } catch (Exception e) {
            return new SeckillResult(SeckillReturnCodeMapping.SYSTEM_ERROR, e.getMessage());
        }
    }

    @PostMapping("/createOrder")
    public SeckillResult createOrder(@RequestBody OrderRequest orderRequest) {
        logger.info("createOrder接收到创建订单请求{}", orderRequest);
        try {
            Integer resultNum = seckillOrderService.createNewOrder(orderRequest);
            if (resultNum > 0) {
                return new SeckillResult(SeckillReturnCodeMapping.SUCCESS_CODE, "订单创建成功！", JsonUtils.objectToJson(orderRequest));
            } else {
                return new SeckillResult(SeckillReturnCodeMapping.BUSINESS_FAIL, "订单创建失败！");
            }
        } catch (Exception e) {
            return new SeckillResult(SeckillReturnCodeMapping.SYSTEM_ERROR, e.getMessage());
        }
    }
}

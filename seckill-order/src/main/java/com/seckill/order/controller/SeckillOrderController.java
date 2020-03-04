package com.seckill.order.controller;

import com.seckill.common.bean.SeckillOrder;
import com.seckill.common.bean.SeckillResult;
import com.seckill.common.constant.SeckillReturnCodeType;
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

import java.util.List;

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
                return new SeckillResult(SeckillReturnCodeType.SUCCESS_CODE, "订单创建成功！", seckillOrder);
            } else {
                return new SeckillResult(SeckillReturnCodeType.BUSINESS_FAIL, "订单创建失败！");
            }
        } catch (Exception e) {
            return new SeckillResult(SeckillReturnCodeType.SYSTEM_ERROR, e.getMessage());
        }
    }

    @PostMapping("/createOrder")
    public SeckillResult createOrder(@RequestBody OrderRequest orderRequest) {
        logger.info("createOrder接收到创建订单请求{}", orderRequest);
        try {
            Integer resultNum = seckillOrderService.createNewOrder(orderRequest);
            if (resultNum > 0) {
                return new SeckillResult(SeckillReturnCodeType.SUCCESS_CODE, "订单创建成功！", JsonUtils.objectToJson(orderRequest));
            } else {
                return new SeckillResult(SeckillReturnCodeType.BUSINESS_FAIL, "订单创建失败！");
            }
        } catch (Exception e) {
            return new SeckillResult(SeckillReturnCodeType.SYSTEM_ERROR, e.getMessage());
        }
    }
    @PostMapping("/findSeckillOrderById")
    public SeckillResult findSeckillOrderById(Long id) {
        try {
            SeckillOrder seckillOrder = seckillOrderService.findSeckillOrderById(id);
            return new SeckillResult(SeckillReturnCodeType.SUCCESS_CODE, "查询订单信息成功", seckillOrder);
        } catch (Exception e) {
            return new SeckillResult(SeckillReturnCodeType.SYSTEM_ERROR, "查询订单信息出错", e);
        }
    }

    @PostMapping("/updateSeckillOrderById")
    public SeckillResult updateSeckillOrderById(@RequestBody SeckillOrder seckillOrder) {
        Integer result = 0;
        try {
            result = seckillOrderService.updateSeckillOrderById(seckillOrder);
            return new SeckillResult(SeckillReturnCodeType.SUCCESS_CODE, "更新订单信息成功", result);
        } catch (Exception e) {
            return new SeckillResult(SeckillReturnCodeType.SYSTEM_ERROR, "更新订单信息出错", e);
        }
    }

    @PostMapping("/listSeckillOrderByTime")
    public SeckillResult listSeckillOrderByTime(Integer timeType, Integer timeSpan, Integer payStatus, Integer orderFlag) {
        try {
            List<SeckillOrder> seckillOrderList = seckillOrderService.listSeckillOrderByTime(timeType, timeSpan, payStatus, orderFlag);
            return new SeckillResult(SeckillReturnCodeType.SUCCESS_CODE, "查询订单信息成功", JsonUtils.objectToJson(seckillOrderList));
        } catch (Exception e) {
            return new SeckillResult(SeckillReturnCodeType.SYSTEM_ERROR, "查询订单信息出错", e);
        }
    }

}

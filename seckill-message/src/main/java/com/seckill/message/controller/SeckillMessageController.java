package com.seckill.message.controller;

import com.seckill.common.bean.SeckillOrder;
import com.seckill.common.entity.OrderRequest;
import com.seckill.message.service.impl.SeckillMessageServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HTTP请求中如果请求参数不加任何注解，默认是@RequestParam，@RequestParam可以接收对象（通过form表单形式传递）
 */
@RequestMapping("/message")
@RestController
public class SeckillMessageController {

    private static final Logger logger = LoggerFactory.getLogger(SeckillMessageController.class);

    @Autowired
    private SeckillMessageServiceImpl seckillMessageServiceImpl;

    @PostMapping("/sendMessage")
    public Boolean sendMessage(@RequestBody OrderRequest orderRequest) {
        logger.info("message组件接收到请求{}", orderRequest);
        try {
            seckillMessageServiceImpl.sendMessage(orderRequest);
        } catch (Exception e) {
            logger.error("发送RabbitMQ消息{}出错，原因{}", orderRequest, e);
            return false;
        }
        return true;
    }

    /**
     * 接收订单创建请求
     * @param orderRequest
     * @return
     */
    @PostMapping("/sendOrderMessage")
    public Boolean sendOrderMessage(@RequestBody OrderRequest orderRequest) {
        try {
            seckillMessageServiceImpl.sendMessage(orderRequest);
        } catch (Exception e) {
            logger.error("sendOrderMessage发送消息{}错误，原因{}", orderRequest, e);
            return false;
        }
        return true;
    }

    @PostMapping("/sendOrderUpdateMessage")
    public Boolean sendOrderUpdateMessage(@RequestBody SeckillOrder seckillOrder) {
        try {
            seckillMessageServiceImpl.sendMessage(seckillOrder);
        } catch (Exception e) {
            logger.error("sendOrderMessage发送消息{}错误，原因{}", seckillOrder, e);
            return false;
        }
        return true;
    }

}

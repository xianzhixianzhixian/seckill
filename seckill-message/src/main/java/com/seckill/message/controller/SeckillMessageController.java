package com.seckill.message.controller;

import com.seckill.message.entiry.OrderInfo;
import com.seckill.message.service.SeckillMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/message")
@RestController
public class SeckillMessageController {

    private static final Logger logger = LoggerFactory.getLogger(SeckillMessageController.class);

    @Autowired
    private SeckillMessageService seckillMessageService;

    @PostMapping("/sendMessage")
    public Boolean sendMessage(@RequestBody OrderInfo orderInfo) {
        logger.info("message组件接收到请求{}", orderInfo);
        try {
            seckillMessageService.sendMessage(orderInfo);
        } catch (Exception e) {
            logger.error("发送RabbitMQ消息{}出错，原因{}", orderInfo, e);
            return false;
        }
        return true;
    }
}

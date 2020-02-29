package com.seckill.message.service.impl;

import com.seckill.message.config.RabbitMessageConvertConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeckillMessageServiceImpl {

    private static final Logger logger = LoggerFactory.getLogger(SeckillMessageServiceImpl.class);

    /**
     * 此接口默认是显示RabbitTemplate，目前只有一个实现
     */
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendMessage(String message) throws Exception {
        logger.info("sendMessage接收到消息{}", message);
        amqpTemplate.convertAndSend(RabbitMessageConvertConfig.SPRING_BOOT_EXCHANGE_OBJECT, RabbitMessageConvertConfig.SPRING_BOOT_BIND_KEY_OBJECT, message);
    }

    public void sendMessage(Object message) throws Exception {
        logger.info("sendMessage接收到消息{}", message);
        amqpTemplate.convertAndSend(RabbitMessageConvertConfig.SPRING_BOOT_EXCHANGE_OBJECT, RabbitMessageConvertConfig.SPRING_BOOT_BIND_KEY_OBJECT, message);
    }

}

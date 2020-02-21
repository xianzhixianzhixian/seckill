package com.seckill.message.service;

import com.seckill.message.config.RabbitMessageConvertConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeckillMessageService {

    private static final Logger logger = LoggerFactory.getLogger(SeckillMessageService.class);

    /**
     * 此接口默认是显示RabbitTemplate，目前只有一个实现
     */
    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * RabbitTemplate发送String消息
     * @param message
     */
    public void sendMessage(String message) throws Exception {
        logger.info("sendMessage接收到消息{}", message);
        amqpTemplate.convertAndSend(RabbitMessageConvertConfig.SPRING_BOOT_EXCHANGE_OBJECT, RabbitMessageConvertConfig.SPRING_BOOT_BIND_KEY_OBJECT, message);
    }

    /**
     * RabbitTemplate发送Object消息
     * @param message
     */
    public void sendMessage(Object message) throws Exception {
        logger.info("sendMessage接收到消息{}", message);
        amqpTemplate.convertAndSend(RabbitMessageConvertConfig.SPRING_BOOT_EXCHANGE_OBJECT, RabbitMessageConvertConfig.SPRING_BOOT_BIND_KEY_OBJECT, message);
    }

}

package com.rabbitmq.producer;

import com.rabbitmq.config.RabbitMQConfig;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * RabbitMQ消息发送
 */
@Component
public class MessageProducer {

    /**
     * 此接口默认实现只有一个且为RabbitAdmin，通过源码发现其内部实现实际是RabbitTemplate
     * 所以AmqpAdmin和AmqpTemplate本质上是相同的
     */
    @Autowired
    private AmqpAdmin amqpAdmin;

    /**
     * 此接口默认是显示RabbitTemplate，目前只有一个实现
     */
    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * RabbitTemplate发送消息
     * @param message
     */
    public void templateSendMessage(String message) {
        amqpTemplate.convertAndSend(RabbitMQConfig.SPRING_BOOT_EXCHANGE, RabbitMQConfig.SPRING_BOOT_BIND_KEY, message);
    }

}

package com.rabbitmq.consumer;

import com.rabbitmq.config.RabbitMQConfig;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * RabbitMQ消息接收
 */
@Component
public class MessageConsumer {

    /**
     * 接收消息的方法
     * 方法一、在RabbitMQ上创建queue、message、binding
     * 方法二、直接使用@RabbitListener注解
     */
    @RabbitListener(
            containerFactory = "rabbitListenerContainerFactory",
            bindings = @QueueBinding(
                    value = @Queue(value = RabbitMQConfig.SPRING_BOOT_QUEUE, durable = "true", autoDelete = "true"),
                    exchange = @Exchange(value = RabbitMQConfig.SPRING_BOOT_EXCHANGE, type = ExchangeTypes.TOPIC),
                    key = RabbitMQConfig.SPRING_BOOT_BIND_KEY
            )
    )public void receiveMessage(String message) {
        System.out.println("receive message：" + message);
    }
}

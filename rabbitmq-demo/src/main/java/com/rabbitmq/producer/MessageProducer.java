package com.rabbitmq.producer;

import com.rabbitmq.config.RabbitMQConfig;
import com.rabbitmq.config.RabbitMessageConvertConfig;
import com.rabbitmq.pojo.Passage;
import com.rabbitmq.pojo.Person;
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
     * RabbitTemplate发送String消息
     * @param message
     */
    public void templateSendMessage(String message) {
        amqpTemplate.convertAndSend(RabbitMQConfig.SPRING_BOOT_EXCHANGE, RabbitMQConfig.SPRING_BOOT_BIND_KEY, message);
    }

    /**
     * RabbitTemplate发送Object消息
     * @param person
     */
    public void templateSendPerson(Person person) {
        amqpTemplate.convertAndSend(RabbitMessageConvertConfig.SPRING_BOOT_EXCHANGE_OBJECT, RabbitMessageConvertConfig.SPRING_BOOT_BIND_KEY_OBJECT, person);
    }

    /**
     * RabbitTemplate发送Object消息
     * @param passage
     */
    public void templateSendPassage(Passage passage) {
        amqpTemplate.convertAndSend(RabbitMessageConvertConfig.SPRING_BOOT_EXCHANGE_OBJECT, RabbitMessageConvertConfig.SPRING_BOOT_BIND_KEY_OBJECT, passage);
    }
}

package com.rabbitmq.consumer;

import com.rabbitmq.config.RabbitMessageConvertConfig;
import com.rabbitmq.pojo.Passage;
import com.rabbitmq.pojo.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @RabbitListener除了可以用在方法上，也可以用在类上；后者，需要在处理的方法使用@RabbitHandler
 * 一个类中可以使用多个@RabbitHandler，根据参数不同请求到不同的RabbitHandler
 */
@Component
@RabbitListener(queues = RabbitMessageConvertConfig.SPRING_BOOT_QUEUE_OBJECT)
public class ObjectMessageConsumer {

    private static final Logger logger = LoggerFactory.getLogger(ObjectMessageConsumer.class);

    /**
     * 获取信息
     * queue也支持RabbitMQ中队列的模糊匹配
     * @param person
     */
    @RabbitHandler
    public void receiverPerson(Person person) {
        logger.info("接受到人的信息{}", person);
    }

    @RabbitHandler
    public void receiverPassage(Passage passage) {
        logger.info("接收到文章的消息{}", passage);
    }
}

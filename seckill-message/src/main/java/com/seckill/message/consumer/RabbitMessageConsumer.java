package com.seckill.message.consumer;

import com.seckill.common.entity.OrderRequest;
import com.seckill.message.config.RabbitMessageConvertConfig;
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
public class RabbitMessageConsumer {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMessageConsumer.class);

    /**
     * 获取信息
     * queue也支持RabbitMQ中队列的模糊匹配
     * @param orderRequest
     */
    @RabbitHandler
    public void receiverOrderMessage(OrderRequest orderRequest) {
        logger.info("接收到的订单信息{}", orderRequest);
    }

    /**
     * 接收String类型的消息
     * @param message
     */
    @RabbitHandler
    public void receiveStringMessage(String message) {
        logger.info("接收到字符串消息{}", message);
    }
}

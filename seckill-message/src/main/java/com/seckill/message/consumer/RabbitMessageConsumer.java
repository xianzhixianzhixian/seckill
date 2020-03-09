package com.seckill.message.consumer;

import com.rabbitmq.client.Channel;
import com.seckill.common.bean.SeckillOrder;
import com.seckill.common.bean.SeckillResult;
import com.seckill.common.constant.SeckillReturnCodeType;
import com.seckill.common.entity.OrderRequest;
import com.seckill.common.entity.event.Event;
import com.seckill.common.entity.event.type.OrderEventType;
import com.seckill.common.utils.JsonUtils;
import com.seckill.message.config.RabbitMessageConvertConfig;
import com.seckill.message.service.feign.SeckillOrderFeignService;
import com.seckill.message.service.feign.SeckillProductFeignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @RabbitListener除了可以用在方法上，也可以用在类上；后者，需要在处理的方法使用@RabbitHandler
 * 一个类中可以使用多个@RabbitHandler，根据参数不同请求到不同的RabbitHandler
 */
@Component
@RabbitListener(queues = RabbitMessageConvertConfig.SPRING_BOOT_QUEUE_OBJECT)
public class RabbitMessageConsumer {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMessageConsumer.class);

    @Autowired
    private SeckillOrderFeignService seckillOrderFeignService;
    @Autowired
    private SeckillProductFeignService seckillProductFeignService;

    /**
     * 获取信息
     * queue也支持RabbitMQ中队列的模糊匹配
     * @param orderRequest
     */
    @RabbitHandler
    public void receiverOrderMessage(OrderRequest orderRequest, Channel channel, Message message) {
        logger.info("接收到的请求订单创建信息{}", orderRequest);
        try {
            SeckillResult seckillResult = seckillOrderFeignService.createOrder(orderRequest);
            orderRequest = JsonUtils.jsonToPojo((String) seckillResult.getData(), OrderRequest.class);
            if (seckillResult != null && SeckillReturnCodeType.SUCCESS_CODE.equals(seckillResult.getStatus())) {
                Event event = new Event(orderRequest.getEventName(), OrderEventType.COMPLETE, orderRequest.getSeckillProduct(), orderRequest.getSeckillOrder(), orderRequest.getSeckillUserResult());
                seckillResult = seckillProductFeignService.sendEvent(event);
                logger.info("发送订单完成事件{}结果{}", event, seckillResult.getStatus());
            }
            //返回消息确认该条消息已经被消费，可以在队列中删除，否则消息服务器将会认为该条消息未被处理导致重发
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            logger.error("receiverOrderMessage错误，原因{}", e);
            try {
                //确认消费未成功
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
            } catch (Exception ackException) {
                logger.error("receiverOrderMessage basicAck错误，原因{}", ackException);
            }
        }
    }

    /**
     * 接收SeckillOrder的更新消息，用于订单信息的异步更新
     * @param seckillOrder
     */
    @RabbitHandler
    public void receiveOrderUpdateMessage(SeckillOrder seckillOrder) {
        logger.info("接收到的请求订单更新信息{}", seckillOrder);
        try {
            SeckillResult seckillResult = seckillOrderFeignService.updateSeckillOrderById(seckillOrder);
            if (seckillResult != null && SeckillReturnCodeType.SUCCESS_CODE.equals(seckillResult.getStatus())) {
                logger.info("receiveOrderUpdateMessage订单更新成功");
            } else {
                logger.info("receiveOrderUpdateMessage订单更新错误");
            }
        } catch (Exception e) {
            logger.error("receiveOrderUpdateMessage错误，原因{}", e);
        }
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

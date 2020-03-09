package com.seckill.message.service.impl;

import com.seckill.common.bean.SeckillOrder;
import com.seckill.common.entity.OrderRequest;
import com.seckill.message.config.RabbitMessageConvertConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeckillMessageServiceImpl implements RabbitTemplate.ReturnCallback {

    private static final Logger logger = LoggerFactory.getLogger(SeckillMessageServiceImpl.class);

    /**
     * 用于发送失败后重新发送消息
     */
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String message) throws Exception {
        logger.info("sendMessage接收到消息{}", message);
        int count = 0;
        rabbitTemplate.setReturnCallback(this::returnedMessage);
        rabbitTemplate.setConfirmCallback(new SeckillMessageConfirmCallback(count, message));
        rabbitTemplate.convertAndSend(RabbitMessageConvertConfig.SPRING_BOOT_EXCHANGE_OBJECT, RabbitMessageConvertConfig.SPRING_BOOT_BIND_KEY_OBJECT, message);
    }

    public void sendOrderRequestMessage(OrderRequest orderRequest) throws Exception {
        logger.info("sendOrderRequestMessage接收到消息{}", orderRequest);
        int count = 0;
        rabbitTemplate.setReturnCallback(this::returnedMessage);
        rabbitTemplate.setConfirmCallback(new SeckillMessageConfirmCallback(count, orderRequest));
        rabbitTemplate.convertAndSend(RabbitMessageConvertConfig.SPRING_BOOT_EXCHANGE_OBJECT, RabbitMessageConvertConfig.SPRING_BOOT_BIND_KEY_OBJECT, orderRequest);
    }

    public void sendSeckillOrderMessage(SeckillOrder seckillOrder) throws Exception {
        logger.info("sendSeckillOrderMessage接收到消息{}", seckillOrder);
        int count = 0;
        rabbitTemplate.setReturnCallback(this::returnedMessage);
        rabbitTemplate.setConfirmCallback(new SeckillMessageConfirmCallback(count, seckillOrder));
        rabbitTemplate.convertAndSend(RabbitMessageConvertConfig.SPRING_BOOT_EXCHANGE_OBJECT, RabbitMessageConvertConfig.SPRING_BOOT_BIND_KEY_OBJECT, seckillOrder);
    }

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        logger.info("returnedMessage：message {} replyCode {} replyText {} exchange {} routingKey {}", message, replyCode, replyText, exchange, routingKey);
    }

    class SeckillMessageConfirmCallback implements RabbitTemplate.ConfirmCallback {

        private Integer count;
        private Object message;

        public SeckillMessageConfirmCallback() {
            this.count = 0;
        }

        public SeckillMessageConfirmCallback(Integer count, Object message) {
            this.count = count;
            this.message = message;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public Object getMessage() {
            return message;
        }

        public void setMessage(Object message) {
            this.message = message;
        }

        /**
         * 确认消息是否发送成功
         * @param correlationData  消息内容
         * @param ack              消息是否发送成功
         * @param cause            消息发送失败时的原因
         */
        @Override
        public void confirm(CorrelationData correlationData, boolean ack, String cause) {
            if (!ack) {
                logger.info("confirme消息{}发送失败，原因{} 次数{}", correlationData.toString(), cause, this.count);
                //重新发送消息
                if (count < 3) {
                    SeckillMessageConfirmCallback confirmCallback = new SeckillMessageConfirmCallback(this.count, this.message);
                    rabbitTemplate.setConfirmCallback(confirmCallback);
                    rabbitTemplate.convertAndSend(RabbitMessageConvertConfig.SPRING_BOOT_EXCHANGE_OBJECT, RabbitMessageConvertConfig.SPRING_BOOT_BIND_KEY_OBJECT, this.message);
                } else {
                    //TODO将消息记录存储到数据库
                }
                this.count ++;
            } else {
                logger.info("sendSeckillOrderMessage消息{}发送成功", this.message);
            }
        }
    }

}

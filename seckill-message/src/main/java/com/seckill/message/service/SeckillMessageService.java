package com.seckill.message.service;

import com.seckill.message.config.RabbitMessageConvertConfig;

public interface SeckillMessageService {

    /**
     * RabbitTemplate发送String消息
     * @param message
     */
    public void sendMessage(String message) throws Exception;

    /**
     * RabbitTemplate发送Object消息
     * @param message
     */
    public void sendMessage(Object message) throws Exception;
}

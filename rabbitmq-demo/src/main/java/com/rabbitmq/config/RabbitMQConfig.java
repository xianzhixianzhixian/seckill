package com.rabbitmq.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    //队列名称
    public final static String SPRING_BOOT_QUEUE = "SPRING_BOOT_QUEUE";

    //交换机名称
    public final static String SPRING_BOOT_EXCHANGE = "SPRING_BOOT_EXCHANGE";

    //绑定值
    public final static String SPRING_BOOT_BIND_KEY = "SPRING_BOOT_BIND_KEY";
}

package com.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMessageConvertConfig {

    //队列名称
    public final static String SPRING_BOOT_QUEUE_OBJECT = "SPRING_BOOT_QUEUE_OBJECT";

    //交换机名称
    public final static String SPRING_BOOT_EXCHANGE_OBJECT = "SPRING_BOOT_EXCHANGE_OBJECT";

    //绑定值
    public final static String SPRING_BOOT_BIND_KEY_OBJECT = "SPRING_BOOT_BIND_KEY_OBJECT";

    /**
     * 定义队列
     * @return
     */
    @Bean
    Queue queue() {
        return new Queue(SPRING_BOOT_QUEUE_OBJECT, false);
    }

    /**
     * 定义交换机
     * @return
     */
    @Bean
    TopicExchange exchange() {
        return new TopicExchange(SPRING_BOOT_EXCHANGE_OBJECT);
    }

    /**
     * 定义绑定
     * @param queue
     * @param topicExchange
     * @return
     */
    @Bean
    Binding binding(Queue queue, TopicExchange topicExchange) {
        return BindingBuilder.bind(queue).to(topicExchange).with(SPRING_BOOT_BIND_KEY_OBJECT);
    }

    /**
     * 定义消息转换实例
     * @return
     */
    @Bean
    MessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    //如果默认的SimpleMessageListenerContainer不符合我们的要求，可以通过如下的方式创建新的SimpleMessageListenerContainer
//    @Bean
//    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory) {
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        container.setConcurrentConsumers(10);
//        return container;
//    }
//
//    @Bean
//    MessageListenerAdapter listenerAdapter(ProductMessageListener receiver) {
//        return new MessageListenerAdapter(receiver, "receiveMessage");
//    }
}

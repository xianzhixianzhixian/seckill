package com.rabbitmq;

import com.rabbitmq.consumer.MessageConsumer;
import com.rabbitmq.producer.MessageProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitmqApplicationDemo.class, value = "spring.profiles.active=boot")
public class RabbitMQTest {

    @Autowired
    private MessageProducer messageProducer;
    @Autowired
    private MessageConsumer messageConsumer;

    @Test
    public void sendMessage() {
        String testMessage = "RabbitMQTest";
        messageProducer.templateSendMessage(testMessage);
        try {
            Thread.sleep(1000 * 10);
        } catch (Exception e) {

        }
    }
}

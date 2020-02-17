package com.rabbitmq;

import com.rabbitmq.consumer.StringMessageConsumer;
import com.rabbitmq.pojo.Passage;
import com.rabbitmq.pojo.Person;
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
    private StringMessageConsumer stringMessageConsumer;

    @Test
    public void sendStringMessage() {
        String testMessage = "RabbitMQTest";
        messageProducer.templateSendMessage(testMessage);
        try {
            Thread.sleep(1000 * 10);
        } catch (Exception e) {

        }
    }

    @Test
    public void sendObjectMessage() {
        Person person = new Person("测试人物信息", 10);
        Passage passage = new Passage(10, "测试文章信息");
        messageProducer.templateSendPerson(person);
        messageProducer.templateSendPassage(passage);
        try {
            Thread.sleep(1000 * 10);
        } catch (Exception e) {

        }
    }
}

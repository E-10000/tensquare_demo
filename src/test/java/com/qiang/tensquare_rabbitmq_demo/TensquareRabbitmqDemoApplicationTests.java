package com.qiang.tensquare_rabbitmq_demo;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TensquareRabbitmqDemoApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void contextLoads() {
        rabbitTemplate.convertAndSend("MyQueue","生产者发送的一条消息");
    }

    @Test
    void test2(){
        rabbitTemplate.convertAndSend("ex_fanout","","分列消息");
    }

    @Test
    void test3(){
        rabbitTemplate.convertAndSend("ex_topic","good.ass","主题模式1");
    }

    @Test
    void test4(){
        rabbitTemplate.convertAndSend("ex_topic","ass.log","主题模式2");
    }

    @Test
    void test5(){
        rabbitTemplate.convertAndSend("ex_topic","good.log","主题模式3");
    }
}

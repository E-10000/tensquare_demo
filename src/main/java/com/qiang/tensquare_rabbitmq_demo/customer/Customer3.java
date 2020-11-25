package com.qiang.tensquare_rabbitmq_demo.customer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
//接受哪个队列的消息
@RabbitListener(queues = "MyQueue3")
public class Customer3 {

    @RabbitHandler
    public void showMsg(String msg){
        System.out.println("队列3接收到消息："+msg);
    }
}

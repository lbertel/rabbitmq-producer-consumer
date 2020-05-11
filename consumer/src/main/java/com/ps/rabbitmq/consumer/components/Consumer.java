package com.ps.rabbitmq.consumer.components;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    public void consumerTrainingId(String msg){
        System.out.println("Received: " + msg );
    }

}

package com.ps.rabbitmq.producer.component;

import com.ps.rabbitmq.producer.util.Constants;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class Producer {

    private final RabbitTemplate rabbitTemplate;

    public Producer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Scheduled(fixedRate = 5000L)
    public void generate(){
        String msg = "Training ID: " + ThreadLocalRandom.current().nextInt(1000000);
        System.out.println("Sending: " + msg);
        this.rabbitTemplate.convertAndSend(Constants.TOPIC_NAME, Constants.REPORTS_QUEUE_PREFIX + "formacion", msg);
    }
}

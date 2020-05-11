package com.ps.rabbitmq.producer;

import com.ps.rabbitmq.producer.util.Constants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ProducerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}

	@Bean
	public Queue queue(){
		return new Queue(Constants.QUEUE_REPORTS, false);
	}

	@Bean
	public TopicExchange exchange(){
		return new TopicExchange(Constants.TOPIC_NAME);
	}

	@Bean
	public Binding binding(Queue queue, TopicExchange exchange){
		return BindingBuilder.bind(queue).to(exchange).with("hola.algo.#");
	}

	@Override
	public void run(String... args) throws Exception {
		Thread.currentThread().join();
	}
}

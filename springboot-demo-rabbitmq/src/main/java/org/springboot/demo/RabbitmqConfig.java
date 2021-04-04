package org.springboot.demo;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RabbitmqConfig {

    @Bean
    public Queue createQueue() {
        return new Queue("hello.world.queue");
    }

    @Bean
    public Exchange createExchange(){
        return ExchangeBuilder.directExchange("hello.world.exchange").durable(true).build();
    }

    @Bean
    public Binding createBinding(Queue queue, Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("hello.world.routing").noargs();
    }
}

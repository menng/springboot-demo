package org.springboot.demo;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveHandler {

    @RabbitListener(queues = "hello.world.queue")
    public void receiveMessage(String msg, Message message, Channel channel) {
        System.out.println(msg);
        System.out.println(message.getBody().toString());
    }
}

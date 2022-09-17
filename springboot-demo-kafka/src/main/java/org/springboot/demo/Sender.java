package org.springboot.demo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springboot.demo.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class Sender {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    private Gson gson = new GsonBuilder().create();

    public void sendMessage() {
        Message message = new Message();
        message.setId(11111L);
        message.setMsg(UUID.randomUUID().toString());
        message.setSendTime(new Date());
        kafkaTemplate.send("quickstart-events", gson.toJson(message));
    }
}

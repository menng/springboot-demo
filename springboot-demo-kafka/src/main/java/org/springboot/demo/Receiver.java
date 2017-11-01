package org.springboot.demo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springboot.demo.domain.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
    private Gson gson = new GsonBuilder().create();

    @KafkaListener(topics = "test1")
    public void processMessage(String content) {
        Message m = gson.fromJson(content, Message.class);
        System.out.println(m.getMsg());
    }
}

package org.springboot.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedisApplication implements CommandLineRunner {

    @Autowired
    private RedisService redisService;

    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }

    @Override
    public void run(String... args){
        // bf.reserve test 0.0000001 100000000
        for(int i=0; i < 1_0000_0000; i++) {
            redisService.addInBloomFilter("test", i + "");
        }
        System.out.println("执行完毕");
    }
}

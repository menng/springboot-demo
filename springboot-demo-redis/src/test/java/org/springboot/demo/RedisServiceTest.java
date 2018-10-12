package org.springboot.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * redis测试
 * created by menng on 2018/10/12 17:17
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisServiceTest {

    @Autowired
    private RedisService redisService;

    @Test
    public void testSet() {
        redisService.set("name", "Harry");
        redisService.set("name", "Poter", 100, TimeUnit.SECONDS);
        redisService.set("name", "World", 5);
        System.out.println(redisService.setIfAbsent("name", "WWW"));
        System.out.println(redisService.get("name"));

        Map<String, String> map = new HashMap<>();
        map.put("name", "Harry");
        map.put("gender", "boy");
        map.put("age", "17");
        redisService.multiSet(map);
        System.out.println(redisService.multiGet(new ArrayList<>(map.keySet())));

        redisService.increment("increment", 1L);
        redisService.append("name", "Hello");
        System.out.println(redisService.size("name"));
        redisService.set("bitTest", "a");
        redisService.setBig("bitTest", 6, true);
        redisService.setBig("bitTest", 7, false);
        System.out.println(redisService.get("bitTest"));

        redisService.leftPush("list", "java");
        redisService.leftPush("list", "python");
        redisService.leftPush("list", "c++");

        long size = redisService.leftPushAll("listAll", "java1", "java2", "java3");
        long size2 = redisService.leftPushAll("allList", Arrays.asList("java4", "java5", "java6"));
        System.out.println(size);
        System.out.println(size2);
        System.out.println(redisService.range("listAll", 0, 1));
        redisService.trim("allList", 1, -1);
        System.out.println(redisService.range("allList", 1, -1));


    }
}

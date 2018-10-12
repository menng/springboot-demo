package org.springboot.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class RedisService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    void set(String key, String value, long timeout, TimeUnit unit) {
        redisTemplate.opsForValue().set(key, value, timeout, unit);
    }

    void set(String key, String value, long offSet) {
        redisTemplate.opsForValue().set(key, value, offSet);
    }

    Boolean setIfAbsent(String key, String value) {
        return redisTemplate.opsForValue().setIfAbsent(key, value);
    }

    void multiSet(Map<String, String> map) {
        redisTemplate.opsForValue().multiSet(map);
    }

    List<String> multiGet(List<String> keys) {
        return redisTemplate.opsForValue().multiGet(keys);
    }

    void getAndSet(String key, String value) {
        redisTemplate.opsForValue().getAndSet(key, value);
    }

    Long increment(String key, long data) {
        return redisTemplate.opsForValue().increment(key, data);
    }

    void append(String key, String value) {
        redisTemplate.opsForValue().append(key, value);
    }

    Long size(String key) {
        return redisTemplate.opsForValue().size(key);
    }

    void setBig(String key, long offset, boolean value) {
        redisTemplate.opsForValue().setBit(key, offset, value);
    }


    void leftPush(String key, String value) {
        redisTemplate.opsForList().leftPush(key, value);
    }

    long leftPushAll(String key, String... value) {
        redisTemplate.opsForList().leftPushAll(key, value);
        return redisTemplate.opsForList().size(key);
    }

    long leftPushAll(String key, List<String> list) {
        redisTemplate.opsForList().leftPushAll(key, list);
        return redisTemplate.opsForList().size(key);
    }

    List<String> range(String key, long start, long end) {
        return redisTemplate.opsForList().range(key, start, end);
    }

    void trim(String key, long start, long end) {
        redisTemplate.opsForList().range(key, start, end);
    }

}

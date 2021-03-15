package com.liqnchun.knowledge.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import reactor.core.publisher.Mono;

import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RedisServiceTest {

    @Autowired
    RedisTemplate redisTemplate;@Autowired
    ReactiveRedisTemplate reactiveRedisTemplate;

    @Autowired
    RedisConnectionFactory redisConnectionFactory;
    @Autowired
    ReactiveRedisConnectionFactory reactiveRedisConnectionFactory;

    @Test
    void getFromRedis() {
        redisTemplate.opsForValue().set("name","liqinchun");
        System.out.println(redisTemplate.opsForValue().get("name"));
        Mono mono = reactiveRedisTemplate.opsForValue().get("name");
        mono.subscribe(System.out::println);
        reactiveRedisTemplate.opsForValue().set("name","aaa");


        System.out.println("redisConnectionFactory"+redisConnectionFactory);
        System.out.println("reactiveRedisConnectionFactory"+reactiveRedisConnectionFactory);
        System.out.println("reactiveRedisTemplate"+reactiveRedisTemplate);
        System.out.println("redisTemplate"+redisTemplate);
//        try {
//            Thread.sleep(6000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
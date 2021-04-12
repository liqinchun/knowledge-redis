package com.liqnchun.knowledge.redis;

import org.redisson.spring.starter.RedissonAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = RedissonAutoConfiguration.class)
public class KnowledgeRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(KnowledgeRedisApplication.class, args);
    }
}

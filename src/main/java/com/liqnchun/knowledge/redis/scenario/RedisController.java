package com.liqnchun.knowledge.redis.scenario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redisson")
public class RedisController {

    @Autowired RedisService redisService;

    @GetMapping("counter")
    public Long inc(String name) {
        return redisService.counter(name);
    }

    @PutMapping("sendMessage")
    public String sendMessage(String message) {
        redisService.sendMessage(message);
        return message;
    }
}

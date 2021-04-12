package com.liqnchun.knowledge.redis.reactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("redis/reactor")
public class ReactorController {

//    @Autowired
//    ReactiveRedisTemplate reactiveRedisTemplate;

//    @GetMapping
//    public Mono<String> getName() {
//        return reactiveRedisTemplate.opsForValue().get("name");
//    }

}

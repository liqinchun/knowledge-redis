package com.liqnchun.knowledge.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    @Autowired
    RedisTemplate redisTemplate;



    public void getFromRedis() {
        redisTemplate.opsForValue().set("aaa","aaaa");
    }





}

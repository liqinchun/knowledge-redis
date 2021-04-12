package com.liqnchun.knowledge.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class RedisService {

     RedisTemplate redisTemplate;

    public RedisService(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        redisTemplate.opsForValue().set("aaa","aaaadsadasdasdasdas");
        System.out.println(redisTemplate.opsForValue().get("aaa"));
    }

    //    @Autowired
    //    StringRedisConnection stringRedisConnection;
    // inject the template as ListOperations
    //    @Resource(name="redisTemplate")
    //    private ListOperations<String, String> listOps;

    public void getFromRedis() {
        //        stringRedisConnection.getNativeConnection();
        redisTemplate.opsForValue().set("aaa", "aaaa");
        redisTemplate.opsForZSet().add("aaad", "dsa", 13D);
        redisTemplate.opsForSet().add("aaad", "dsa", 13D);
        redisTemplate.opsForHash().put("aaa", "aaa", "aaaaa");
        redisTemplate.opsForList().leftPush("ddd", "dddd");
        redisTemplate.opsForGeo().add("", new HashSet<>());
        redisTemplate.opsForHyperLogLog().add("a", "", "");
        redisTemplate.opsForStream();
        redisTemplate.boundGeoOps("ddd");
    }
}

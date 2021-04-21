package com.liqnchun.knowledge.redis.redisson;

import org.redisson.api.*;
import org.springframework.stereotype.Service;

@Service
public class RedissonService {

    public RedissonService(RedissonClient redisClient) {
        RAtomicLong longObject = redisClient.getAtomicLong("myLong");
        longObject.compareAndSet(3, 401);
        RFuture<Boolean> result = longObject.compareAndSetAsync(3, 401);

    }
}

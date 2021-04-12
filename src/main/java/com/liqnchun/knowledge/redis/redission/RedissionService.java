package com.liqnchun.knowledge.redis.redission;

import org.redisson.Redisson;
import org.redisson.api.*;
import org.redisson.client.RedisClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class RedissionService {

    public RedissionService(RedissonClient redisClient) {
        RAtomicLong longObject = redisClient.getAtomicLong("myLong");
        longObject.compareAndSet(3, 401);
        RFuture<Boolean> result = longObject.compareAndSetAsync(3, 401);

    }
}

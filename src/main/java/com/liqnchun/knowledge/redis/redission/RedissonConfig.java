package com.liqnchun.knowledge.redis.redission;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;
import org.redisson.Redisson;
import org.redisson.api.*;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

@Configuration
public class RedissonConfig {

    @Bean
    public RedissonClient redissonClient() {
        var config = new Config();
        config.useClusterServers()
                .setScanInterval(2000) // cluster state scan interval in milliseconds
                // use "rediss://" for SSL connection
                .addNodeAddress("redis://192.168.31.174:55001", "redis://192.168.31.174:55002")
                .addNodeAddress("redis://192.168.31.174:55003");
        RedissonClient redissonClient = Redisson.create(config);

        RAtomicLong longObject = redissonClient.getAtomicLong("myLong");
// 同步执行方式
        longObject.compareAndSet(3, 401);
        // 异步执行方式
        RFuture<Boolean> result = longObject.compareAndSetAsync(3, 401);

        RedissonReactiveClient redissonReactiveClient = Redisson.createReactive(config);
        RAtomicLongReactive rAtomicLongReactive = redissonReactiveClient.getAtomicLong("myLong");
// 异步流执行方式
        Mono<Boolean> rAtomicLongReactiveResult = rAtomicLongReactive.compareAndSet(3, 401);
        RedissonRxClient client = Redisson.createRx(config);
        RAtomicLongRx reRxLongObject= client.getAtomicLong("myLong");
// RxJava2方式
        Single<Boolean> ree = reRxLongObject.compareAndSet(3, 401);

        return redissonClient;
    }
}

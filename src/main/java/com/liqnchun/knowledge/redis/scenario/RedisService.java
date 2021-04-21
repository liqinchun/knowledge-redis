package com.liqnchun.knowledge.redis.scenario;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Service
public class RedisService {

    RedisTemplate redisTemplate;
    @Autowired StringRedisTemplate stringRedisTemplate;
    @Autowired RedissonClient redissonClient;

    public RedisService(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        redisTemplate.opsForValue().set("aaa", "aaaadsadasdasdasdas");
        //        redisTemplate.opsForHash().put("aaa", "aaa", "aaaaa");
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

    public Long counter(String name) {
        redisTemplate.opsForValue().increment(name);
        stringRedisTemplate.opsForValue().increment(name);
        return redissonClient.getAtomicLong(name).incrementAndGet();
    }

    public void lock() {
        RLock lock = redissonClient.getLock("anyLock");
        try {
            lock.lockAsync();
            lock.lockAsync(10, TimeUnit.SECONDS);
            Future<Boolean> res = lock.tryLockAsync(100, 10, TimeUnit.SECONDS);
            redissonClient.getFairLock("fairLock");
        } finally {
            lock.unlock();
        }
    }

    public void deck() {
        redisTemplate
                .opsForSet()
                .add(
                        "deck", "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10", "CJ",
                        "CQ", "CK ", "D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "D10",
                        "DJ", "DQ", "DK", "H1", "H2", "H3 ", "H4", "H5", "H6", "H7", "H8", "H9",
                        "H10", "HJ", "HQ", "HK", "S1", "S2", "S3", "S4", "S5", "S6 ", "S7", "S8",
                        "S9", "S10", "SJ", "SQ", "SK");
        System.out.println(redisTemplate.opsForSet().size("deck"));
        var object = "";
        int i = 1;
        while (object != null) {
            var deck = redisTemplate.opsForSet().pop("deck");
            object = deck == null ? null : (String) deck;
            if (deck != null) {
                System.out.print(deck + " |");
            }
            if (i++ % 4 == 0) {
                System.out.println();
            }
        }
    }

    public void atomix() {
        redisTemplate.opsForValue().getAndSet("key","value");
    }

    public void sendMessage(String message) {
        redisTemplate.convertAndSend("channelA", message);
    }
}

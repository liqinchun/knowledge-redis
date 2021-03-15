package com.liqnchun.knowledge.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

//@Configuration
public class JedisConfig {


    @Autowired
    RedisProperties redisProperties;

    @Bean
    public RedisConnectionFactory connectionFactory() {
        return new JedisConnectionFactory(
                new RedisClusterConfiguration(redisProperties.getCluster().getNodes())
        );
    }
}

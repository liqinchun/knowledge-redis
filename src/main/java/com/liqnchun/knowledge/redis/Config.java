package com.liqnchun.knowledge.redis;

import org.springframework.context.annotation.Import;
import org.springframework.data.redis.core.HashOperations;

@Import(HashOperations.class)
public class Config {
}

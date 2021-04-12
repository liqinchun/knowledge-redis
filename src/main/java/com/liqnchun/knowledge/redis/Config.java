package com.liqnchun.knowledge.redis;

import java.util.function.Function;

//@Import(HashOperations.class)
public class Config {



    public static void funcPlus(int value, Function<Integer, Integer> func) {
        System.out.println(func.apply(value));
    }

}

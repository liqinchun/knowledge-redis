package com.liqnchun.knowledge.redis.message;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class RedisMessageListener implements MessageListener {

    @Override
    public void onMessage(Message message, byte[] pattern) {
        System.out.println("接受数据" + message.toString());
        System.out.println("订阅频道:" + new String(message.getChannel()));
    }
}

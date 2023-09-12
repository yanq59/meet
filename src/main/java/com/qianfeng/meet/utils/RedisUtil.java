package com.qianfeng.meet.utils;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisUtil {
    //创建Jedis连接池对象
    private static JedisPool jedisPool = null;
    //在static代码块中，配置连接池的信息
    static {
        //连接池的配置对象
        GenericObjectPoolConfig config = new GenericObjectPoolConfig<>();
        config.setMaxTotal(5);;//连接池中最大连接数量
        config.setMaxIdle(1);//空闲连接的数量
        config.setMaxWaitMillis(3000);//获取连接的超时时间
        //创建连接池对象
        jedisPool = new JedisPool(config,"127.0.0.1",6379);
    }

    //从连接池获取连接的方法
    public static Jedis getJedis(){
        return jedisPool.getResource();
    }
}

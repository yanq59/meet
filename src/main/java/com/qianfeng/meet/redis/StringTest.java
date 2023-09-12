package com.qianfeng.meet.redis;

import redis.clients.jedis.Jedis;

public class StringTest {
    public static void main(String[] args) {
//        1.创建和redis服务的链接
        Jedis jedis = new Jedis("127.0.0.1",6379);
//        所有对 redis 的操作都是通过jedis来完成的
        jedis.select(1);
//        存入值到 redis 中
        jedis.set("zhao","赵宏宇");
        System.out.println("存入redis成功!");

//        从redis中获取数据
        String zhao = jedis.get("zhao");
        System.out.println("获取" + zhao + "成功");

//        关闭资源
        jedis.close();
    }
}

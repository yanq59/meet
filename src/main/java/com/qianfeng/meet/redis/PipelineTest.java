package com.qianfeng.meet.redis;

import com.qianfeng.meet.utils.RedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

public class PipelineTest {
    public static void main(String[] args) {
        Jedis jedis = RedisUtil.getJedis();
        jedis.select(5);
        jedis.set("num1","1");

        long start1 = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {
            jedis.incr("num1");
        }

        long end1 = System.currentTimeMillis();

        //以管道方式运行
        jedis.select(6);
        jedis.set("num2","1");

        //获取管道对象
        Pipeline pipeline = jedis.pipelined();
        long start2 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            pipeline.incr("num2");
            if (i % 1000 == 0){
                //把管道里的命令提交到redis服务器进行执行
                pipeline.syncAndReturnAll();
            }
        }

        long end2 = System.currentTimeMillis();

        System.out.println("非管道方式运行用时："+(end1-start1));
        System.out.println("管道方式运行用时："+(end2-start2));
    }

}

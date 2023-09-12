package com.qianfeng.meet.redis;

import com.qianfeng.meet.pojo.Dept;
import redis.clients.jedis.Jedis;

import java.util.List;

public class HashTest {
    public static void main(String[] args) {
        Dept dept = new Dept();
        dept.setDeptNo(1001);
        dept.setDeptName("java2302");
        dept.setLoc("设计城");

//      使用redis的hash类型存储
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.select(1);
        jedis.hset("dept1","deptNo",String.valueOf(dept.getDeptNo()));
        jedis.hset("dept1","deptName",dept.getDeptName());
        jedis.hset("dept1","loc", dept.getLoc());

        System.out.println("存入成功");

        List<String> list = jedis.hmget("dept1","deptNo","deptName","loc");

        Dept newDept = new Dept();
        newDept.setDeptNo(Integer.parseInt(jedis.hget("dept1","deptNo")));
        newDept.setDeptName(jedis.hget("dept1","deptName"));
        newDept.setLoc(jedis.hget("dept1","loc"));

        System.out.println(list.toString());
        System.out.println(newDept);

    }
}

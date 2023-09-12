package com.qianfeng.meet.service.impl;

import com.alibaba.fastjson.JSON;
import com.qianfeng.meet.dao.BookMapper;
import com.qianfeng.meet.dao.MeetMapper;
import com.qianfeng.meet.pojo.Book;
import com.qianfeng.meet.pojo.Meet;
import com.qianfeng.meet.service.MeetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.SerializationUtils;
import redis.clients.jedis.Jedis;

import java.util.*;

@Service
public class MeetServiceImpl implements MeetService {
    @Autowired
    MeetMapper meetMapper;
    @Autowired
    BookMapper bookMapper;

    @Override
    public List<Meet> findAllRedisJson() {
        List<Meet> meetList = null;
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.select(3);

        //先到redis 获取所有的redis信息
        String jsonValue = jedis.get("meetList");
        //判断是否获取到，如果获取到，直接返回给controller
        if(jsonValue == null){
            //如果没有获取到：
            //1、到数据库获取
            meetList = meetMapper.findAllRedis();
            //2、存入redis
            //以JSON字符串来存储
            jsonValue = JSON.toJSONString(meetList);
            System.out.println("JSON:"+ jsonValue);
            //存入
            jedis.set("meetList",jsonValue);
            System.out.println("从数据库获取，然后存入redis");
        }else {
            //从redis获取到了会议室信息
            //把json字符串转成集合
            System.out.println("直接从redis获取");
            System.out.println("获取到的JSON:"+jsonValue);
            meetList= JSON.parseArray(jsonValue,Meet.class);
        }
        return meetList;
    }

    @Override
    public String findAllRedis() {
        //把获取到的会议室信息存入redis
        List<Meet> meetList = meetMapper.findAllRedis();

        //以byte[]数组方式存入redis
        //【要求】  key  value都得是byte[]类型
        //把对象转成byte[]需要工具 springcontext
        String key = "meetList";
        byte[] byteKey = key.getBytes();

        //把java对象 转成byte数组
        byte[] byteValue= SerializationUtils.serialize(meetList);

        Jedis jedis=new Jedis("127.0.0.1",6379);
        jedis.select(2);

        //string类型
        jedis.set(byteKey,byteValue);
        System.out.println("把会议室集合，转成byte[]后，存入到了Redis中");

        //获取byte[]
        byte[] getByteValue=jedis.get(byteKey);
        //把byte[] 转回成java对象
        List<Meet> getMeetList = (List<Meet>)SerializationUtils.deserialize(getByteValue);

        System.out.println("获取到的集合如下：");
        System.out.println(getMeetList);
        return "存取成功！";
    }

    @Override
    public Meet selectByPrimaryKey(Integer meetId) {
        return meetMapper.selectByPrimaryKey(meetId);
    }

    @Override
    public List<Meet> findAllMeet(String dates) {
        return meetMapper.findAllRoom(dates);
    }

    @Override
    public int deleteByPrimaryKey(Integer meetId) {
        return meetMapper.deleteByPrimaryKey(meetId);
    }

    @Override
    public Map<String, Object>[] selectDailyMeeting(String date) {
        List<Meet> meetList = meetMapper.selectAll();
        Map<String, Object>[] meetMaps = new Map[meetList.size()];
        for (int i = 0; i < meetList.size(); i++) {
            Meet meet = meetList.get(i);
            meetMaps[i] = new HashMap<>();
            meetMaps[i].put("meet",meet);
            List<Book> books = bookMapper.selectByCondition(date,meet.getMeetId());
            meetMaps[i].put("books",books);
        }
        return meetMaps;
    }

    @Override
    public int updateByPrimaryKeySelective(Meet meet) {
        return meetMapper.updateByPrimaryKeySelective(meet);
    }

    @Override
    public List<Meet> selectCondition(String meetName, String loc, Integer statusId) {
        return meetMapper.selectByCondition(meetName, loc, statusId);
    }

    @Override
    public List<Meet> selectAll() {
        return meetMapper.selectAll();
    }
}

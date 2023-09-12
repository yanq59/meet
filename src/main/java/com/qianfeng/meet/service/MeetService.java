package com.qianfeng.meet.service;

import com.qianfeng.meet.pojo.Meet;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface MeetService {

    String findAllRedis();

    List<Meet> findAllRedisJson();

    Meet selectByPrimaryKey(Integer meetId);

    List<Meet> findAllMeet(String dates);

    List<Meet> selectAll();

    List<Meet> selectCondition(String meetName,
                               String loc,
                               Integer statusId);

    int updateByPrimaryKeySelective(Meet meet);

    int deleteByPrimaryKey(Integer meetId);

    Map<String, Object>[] selectDailyMeeting(String date);
}

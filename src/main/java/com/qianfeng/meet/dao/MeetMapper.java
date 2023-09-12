package com.qianfeng.meet.dao;

import com.qianfeng.meet.pojo.Meet;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeetMapper {

    //参数是  会议室的预定日期
    //查询所有会议室，及每个会议室  的  对应预定日期的预定信息
    List<Meet> findAllRoom(String dates);

    List<Meet> selectAll();

    List<Meet> selectByCondition(@Param("meetName") String meetName,
                                 @Param("loc") String loc,
                                 @Param("statusId") Integer statusId);

    List<Meet> findAllRedis();

    int deleteByPrimaryKey(Integer meetId);

    int insert(Meet record);

    int insertSelective(Meet record);

    Meet selectByPrimaryKey(Integer meetId);

    int updateByPrimaryKeySelective(Meet record);

    int updateByPrimaryKey(Meet record);
}

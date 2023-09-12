package com.qianfeng.meet.dao;

import com.qianfeng.meet.pojo.MeetTime;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeetTimeMapper {

    List<MeetTime> selectAll();

    int deleteByPrimaryKey(Integer meetTimeId);

    int insert(MeetTime record);

    int insertSelective(MeetTime record);

    MeetTime selectByPrimaryKey(Integer meetTimeId);

    int updateByPrimaryKeySelective(MeetTime record);

    int updateByPrimaryKey(MeetTime record);
}

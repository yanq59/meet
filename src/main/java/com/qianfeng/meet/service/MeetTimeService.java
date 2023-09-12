package com.qianfeng.meet.service;

import com.qianfeng.meet.pojo.MeetTime;

import java.util.List;

public interface MeetTimeService {
    List<MeetTime> selectAll();

    int insertSelective(MeetTime meetTime);

    int deleteByPrimaryKey(Integer meetTimeId);

    MeetTime selectByMeetTimeId(Integer meetTimeId);
}

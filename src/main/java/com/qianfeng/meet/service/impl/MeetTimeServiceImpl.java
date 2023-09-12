package com.qianfeng.meet.service.impl;

import com.qianfeng.meet.dao.MeetTimeMapper;
import com.qianfeng.meet.pojo.MeetTime;
import com.qianfeng.meet.service.MeetService;
import com.qianfeng.meet.service.MeetTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetTimeServiceImpl implements MeetTimeService {
    @Autowired
    MeetTimeMapper meetTimeMapper;


    @Override
    public MeetTime selectByMeetTimeId(Integer meetTimeId) {
        return meetTimeMapper.selectByPrimaryKey(meetTimeId);
    }

    @Override
    public int deleteByPrimaryKey(Integer meetTimeId) {
        return meetTimeMapper.deleteByPrimaryKey(meetTimeId);
    }

    @Override
    public int insertSelective(MeetTime meetTime) {
        return meetTimeMapper.insertSelective(meetTime);
    }

    @Override
    public List<MeetTime> selectAll() {
        return meetTimeMapper.selectAll();
    }
}

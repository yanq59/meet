package com.qianfeng.meet.service.impl;

import com.qianfeng.meet.dao.TstatusMapper;
import com.qianfeng.meet.pojo.Tstatus;
import com.qianfeng.meet.service.TstatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TstatusServiceImpl implements TstatusService {
    @Autowired
    TstatusMapper tstatusMapper;

    @Override
    public int deleteByPrimaryKey(Integer statusId) {
        return tstatusMapper.deleteByPrimaryKey(statusId);
    }

    @Override
    public int insertSelective(Tstatus tstatus) {
        return tstatusMapper.insertSelective(tstatus);
    }

    @Override
    public List<Tstatus> selectAll() {
        return tstatusMapper.selectAll();
    }
}

package com.qianfeng.meet.service;

import com.qianfeng.meet.pojo.Tstatus;

import java.util.List;

public interface TstatusService {
    List<Tstatus> selectAll();

    int insertSelective(Tstatus tstatus);

    int deleteByPrimaryKey(Integer statusId);
}

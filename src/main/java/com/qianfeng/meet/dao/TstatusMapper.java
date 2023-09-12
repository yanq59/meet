package com.qianfeng.meet.dao;

import com.qianfeng.meet.pojo.Tstatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TstatusMapper {

    List<Tstatus> selectAll();

    int deleteByPrimaryKey(Integer statusId);

    int insert(Tstatus record);

    int insertSelective(Tstatus record);

    Tstatus selectByPrimaryKey(Integer statusId);

    int updateByPrimaryKeySelective(Tstatus record);

    int updateByPrimaryKey(Tstatus record);
}

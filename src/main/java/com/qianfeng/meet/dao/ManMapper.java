package com.qianfeng.meet.dao;

import com.qianfeng.meet.pojo.Man;

import java.util.List;

public interface ManMapper {

    List<Man> selectAll();

    List<Man> selectAllz();

    Man login(Integer manId,String pwd);

    int deleteByPrimaryKey(Integer manId);

    int insert(Man record);

    int insertSelective(Man record);

    Man selectByPrimaryKey(Integer manId);

    int updateByPrimaryKeySelective(Man record);

    int updateByPrimaryKey(Man record);

}

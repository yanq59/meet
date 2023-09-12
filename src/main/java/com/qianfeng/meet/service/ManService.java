package com.qianfeng.meet.service;

import com.qianfeng.meet.pojo.Man;

import java.util.List;

public interface ManService {

    List<Man> selectAllz();

    Man login(Integer manId,String pwd);

}

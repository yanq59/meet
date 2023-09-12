package com.qianfeng.meet.service.impl;

import com.qianfeng.meet.dao.ManMapper;
import com.qianfeng.meet.pojo.Man;
import com.qianfeng.meet.service.ManService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManServiceImpl implements ManService {
    @Autowired
    ManMapper manMapper;

    @Override
    public List<Man> selectAllz() {
        return manMapper.selectAllz();
    }

    @Override
    public Man login(Integer manId, String pwd) {
        return manMapper.login(manId,pwd);
    }
}

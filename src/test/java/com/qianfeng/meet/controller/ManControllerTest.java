package com.qianfeng.meet.controller;

import com.qianfeng.meet.MeetApplication;
import com.qianfeng.meet.service.ManService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)  //测试类需要spring容器
@SpringBootTest(classes = MeetApplication.class)  //需要先运行启动类，自动装配需要的资源
public class ManControllerTest {
    @Autowired
    ManService manService;
    @Test
    public void selectAll() {
        System.out.println(manService.selectAllz());
    }
}

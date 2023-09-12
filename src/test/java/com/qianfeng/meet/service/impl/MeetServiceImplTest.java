package com.qianfeng.meet.service.impl;

import com.qianfeng.meet.MeetApplication;
import com.qianfeng.meet.service.MeetService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)  //测试类需要spring容器
@SpringBootTest(classes = MeetApplication.class)  //需要先运行启动类，自动装配需要的资源
public class MeetServiceImplTest {
    @Autowired
    MeetService meetService;

    @Test
    public void selectDailyMeeting() {
//        Date date = new Date();
        System.out.println(Arrays.toString(meetService.selectDailyMeeting("2023-09-05")));
    }
}

package com.qianfeng.meet.controller;

import com.qianfeng.meet.pojo.Meet;
import com.qianfeng.meet.service.MeetService;
import com.qianfeng.meet.service.MeetTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/meet")
@CrossOrigin("*")
public class MeetController {
    @Autowired
    MeetService meetService;
    @Autowired
    MeetTimeService meetTimeService;

    @GetMapping("/findAllRedisJson")
    public List<Meet> findAllRedisJson(){
        return meetService.findAllRedisJson();
    }

    @GetMapping("/findAllRedis")
    public String findAllRedis(){
        return meetService.findAllRedis();
    }

// 老师: 通过日期查的当天的所有会议室并有预约信息属性
    @GetMapping("/findAllMeet")
    public List<Meet> findAllMeet(String dates){
        return meetService.findAllMeet(dates);
    }
// 老师: 为了前端渲染, 发一个ajax 查所有时间和会议室
    @GetMapping("/findMeetAndMeetTime")
    public Map<String,Object> findMeetAndMeetTime(String dates){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("meets",meetService.findAllMeet(dates));
        map.put("times",meetTimeService.selectAll());
        return map;
    }

    @GetMapping("/selectByMeetId")
    public Meet selectByMeetId(Integer meetId){
        return meetService.selectByPrimaryKey(meetId);
    }

    @DeleteMapping("/deleteMeet")
    public String deleteMeet(Integer meetId){
        int result = meetService.deleteByPrimaryKey(meetId);
        if (result != 0){
            return "success";
        }else {
            return "fail";
        }
    }

    @PutMapping("/updateMeet")
    public String updateMeet(@RequestBody Meet meet){
        int result = meetService.updateByPrimaryKeySelective(meet);
        if (result != 0){
            return "success";
        }else {
            return "fail";
        }
    }

    @GetMapping("/selectCondition")
    public Map<String,Object> selectCondition(String meetName, String loc, Integer statusId){
        Map<String,Object> map = new HashMap<>();
        List<Meet> list = meetService.selectCondition(meetName, loc, statusId);
        map.put("dataList",list);
        map.put("totalSize",list.size());
        return map;
    }

    @GetMapping("/selectAll")
    public Map<String,Object> selectAll(){
        Map<String,Object> map = new HashMap<>();
        List<Meet> list = meetService.selectAll();
        map.put("dataList",list);
        map.put("totalSize",list.size());
        return map;
    }

    @GetMapping("/daily")
    public Map<String,Object>[] selectDailyMeeting(String date){
        return meetService.selectDailyMeeting(date);
    }
}

package com.qianfeng.meet.controller;


import com.qianfeng.meet.pojo.MeetTime;
import com.qianfeng.meet.service.MeetTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meetTime")
@CrossOrigin("*")
public class MeetTimeController {
    @Autowired
    MeetTimeService meetTimeService;

    @GetMapping("/selectByMeetTimeId")
    public MeetTime selectByMeetTimeId(Integer meetTimeId){
        return meetTimeService.selectByMeetTimeId(meetTimeId);
    }

    @GetMapping("/selectAll")
    public List<MeetTime> selectAll() {
        return meetTimeService.selectAll();
    }

    @PostMapping("/insertMeetTime")
    public String insertMeetTime(@RequestBody MeetTime meetTime){
        int result = meetTimeService.insertSelective(meetTime);
        if (result != 0){
            return "success";
        }else {
            return "fail";
        }
    }

    @DeleteMapping("/deleteMeetTime")
    public String deleteByPrimaryKey(Integer meetTimeId){
        int result = meetTimeService.deleteByPrimaryKey(meetTimeId);
        if (result != 0){
            return "success";
        }else {
            return "fail";
        }
    }


}

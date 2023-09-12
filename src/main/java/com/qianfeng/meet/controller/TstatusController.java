package com.qianfeng.meet.controller;

import com.qianfeng.meet.pojo.Tstatus;
import com.qianfeng.meet.service.TstatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tstatus")
@CrossOrigin("*")
public class TstatusController {
    @Autowired
    TstatusService tstatusService;

    @DeleteMapping("/deleteTstatus")
    public String deleteByPrimaryKey(Integer statusId){
        int result = tstatusService.deleteByPrimaryKey(statusId);
        if (result != 0){
            return "success";
        }else {
            return "fail";
        }
    }

    @PostMapping("/insertTstatus")
    public String insertTstatus(@RequestBody Tstatus tstatus){
        int result = tstatusService.insertSelective(tstatus);
        if (result != 0){
            return "success";
        }else {
            return "fail";
        }
    }

    @GetMapping("/selectAll")
    public List<Tstatus> selectAll(){
        return tstatusService.selectAll();
    }
}

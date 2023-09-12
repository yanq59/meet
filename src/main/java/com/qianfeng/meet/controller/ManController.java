package com.qianfeng.meet.controller;


import com.qianfeng.meet.pojo.Man;
import com.qianfeng.meet.service.ManService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/man")
@CrossOrigin("*")
public class ManController {
    @Autowired
    ManService manService;

    @GetMapping("/selectAllz")
    public List<Man> selectAllz(){
        return manService.selectAllz();
    }

    @PostMapping("/login")
    public Man login(@RequestBody Man man){
        return manService.login(man.getManId(),man.getPwd());
    }
}

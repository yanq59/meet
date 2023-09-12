package com.qianfeng.meet.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * redis学习用
 ***/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept {
    private Integer deptNo;
    private String deptName;
    private String loc;
}

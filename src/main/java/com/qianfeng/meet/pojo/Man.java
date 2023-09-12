package com.qianfeng.meet.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Man implements Serializable {
    private Integer manId;

    private String manName;

    private String phone;

    private String pwd;

    private Integer mroleId;

    private Role role;

}

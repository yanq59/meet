package com.qianfeng.meet.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tstatus implements Serializable {
    private Integer statusId;

    private String statusName;

}

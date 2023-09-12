package com.qianfeng.meet.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Meet implements Serializable {
    private Integer meetId;

    private String meetName;

    private String loc;

    private String hasTv;

    private Integer num;

    private Integer statusId;

    private Tstatus tstatus;

//    老师: 一对多, 查询会议室的时候, 也有他的所有预定信息
    private List<Book> bookList;
}

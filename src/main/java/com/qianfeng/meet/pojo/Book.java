package com.qianfeng.meet.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Serializable {
    private Integer bookId;

    private String theme;

    private Integer appendNum;

//    主持人Id
    private Integer hostId;

//    会议室id
    private Integer meetId;

    private String meetType;

//    会议日期年月日
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date meetDate;


    private Integer beginTimeId;

    private String beginTime;

    private Integer endTimeId;

    private  String endTime;

    private String appendMan;

    private String bookMan;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone="GMT+8")
    private Date bookTime;

    private Man man;

    private MeetTime meetTime;

//    private Meet meet;

}

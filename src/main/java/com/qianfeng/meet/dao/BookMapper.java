package com.qianfeng.meet.dao;

import com.qianfeng.meet.pojo.Book;
import com.qianfeng.meet.pojo.Meet;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface BookMapper {

    List<Book> selectLikeName(@Param("manName") String manName,@Param("meetDate") String meetDate);

    List<Book> selectByMeetId(Integer meetId);

    List<Book> selectAll();

    List<Book> selectByMeetDate(String meetDate);

    List<Book> selectByCondition(@Param("meetDate") String meetDate, @Param("meetId") Integer meetId);


    int deleteByPrimaryKey(Integer bookId);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer bookId);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);
}

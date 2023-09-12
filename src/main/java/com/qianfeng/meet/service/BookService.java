package com.qianfeng.meet.service;

import com.qianfeng.meet.pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface BookService {

    List<Book> selectLikeName(String manName,String meetDate);

    int deleteByPrimaryKey(Integer bookId);

    int updateByPrimaryKey(Book book);

    List<Book> selectByCondition( String meetDate, Integer meetId);

    List<Book> selectByMeetDate(String meetDate);

    List<Book> selectAll();

    int insertSelective(Book book);

    List<Book> selectByMeetId(Integer meetId);

    Map<String,Object> selectTime(Integer meetId);
}

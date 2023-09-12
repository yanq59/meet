package com.qianfeng.meet.service.impl;

import com.qianfeng.meet.dao.BookMapper;
import com.qianfeng.meet.dao.MeetTimeMapper;
import com.qianfeng.meet.pojo.Book;
import com.qianfeng.meet.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookMapper bookMapper;
    @Autowired
    MeetTimeMapper meetTimeMapper;

    @Override
    public List<Book> selectLikeName(String manName, String meetDate) {
        return bookMapper.selectLikeName(manName,meetDate);
    }

    @Override
    public int deleteByPrimaryKey(Integer bookId) {
        return bookMapper.deleteByPrimaryKey(bookId);
    }

    @Override
    public int updateByPrimaryKey(Book book) {
        return bookMapper.updateByPrimaryKey(book);
    }

    @Override
    public List<Book> selectByMeetDate(String meetDate) {
        return bookMapper.selectByMeetDate(meetDate);
    }

    @Override
    public List<Book> selectByCondition(String meetDate, Integer meetId) {
        return bookMapper.selectByCondition(meetDate, meetId);
    }

    @Override
    public List<Book> selectAll() {
        return bookMapper.selectAll();
    }

    @Override
    public Map<String, Object> selectTime(Integer meetId) {
        Map<String, Object> map = new HashMap<>();
        Integer beginTimeId = 0;
        Integer endTimeId = 0;
        List<Book> list = bookMapper.selectByMeetId(meetId);
        for (int i = 0; i < list.size(); i++) {
            beginTimeId =list.get(i).getBeginTimeId();
            endTimeId = list.get(i).getEndTimeId();
            map.put("meetId",list.get(i).getBookId());
            map.put("beginTime",meetTimeMapper.selectByPrimaryKey(beginTimeId));
            map.put("endTime",meetTimeMapper.selectByPrimaryKey(endTimeId));

            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
            String transformDate=simpleDateFormat.format(list.get(i).getBookTime());
            map.put("bookTime",transformDate);
        }
        return map;
    }

    @Override
    public List<Book> selectByMeetId(Integer meetId) {
        return bookMapper.selectByMeetId(meetId);
    }

    @Override
    public int insertSelective(Book book) {
        return bookMapper.insertSelective(book);
    }
}

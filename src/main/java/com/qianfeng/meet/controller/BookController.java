package com.qianfeng.meet.controller;


import com.qianfeng.meet.pojo.Book;
import com.qianfeng.meet.pojo.Meet;
import com.qianfeng.meet.service.BookService;
import com.qianfeng.meet.service.MeetService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/book")
@CrossOrigin("*")
public class BookController {
    @Autowired
    BookService bookService;

    @Autowired
    MeetService meetService;

    @GetMapping("/selectLikeName")
    public Map<String,Object> selectLikeName( String manName, String meetDate){
        Map<String,Object> map = new HashMap<>();
        List<Book> bookList = bookService.selectLikeName(manName, meetDate);
        map.put("bookList",bookList);
        map.put("totalSize",bookList.size());
        return map;
    }

    @DeleteMapping("/deleteByBookId")
    public String deleteByBookId(Integer bookId){
        int result = bookService.deleteByPrimaryKey(bookId);
        if (result != 0){
            return "success";
        }else {
            return "fail";
        }
    }

    @PutMapping("/updateByBookId")
    public String updateByBookId(@RequestBody Book book){
        int result = bookService.updateByPrimaryKey(book);
        if (result != 0){
            return "success";
        }else {
            return "fail";
        }
    }

    @GetMapping("/selectByMeetDate")
    public Map<String,Object> selectByMeetDate(String meetDate){
        Map<String,Object> map = new HashMap<>();
        List<Book> bookList = bookService.selectByMeetDate(meetDate);
        map.put("bookList",bookList);
        map.put("totalSize",bookList.size());

        return map;
    }

    @GetMapping("/selectAll")
    public List<Book> selectAll(){
        return bookService.selectAll();
    }

    @GetMapping("/selectTime")
    public Map<String,Object> selectTime(Integer meetId){
        return bookService.selectTime(meetId);
    }

    @GetMapping("/selectByMeetId")
    public List<Book>  selectByMeetId(Integer meetId){
        return bookService.selectByMeetId(meetId);
    }

    @PostMapping("/insertBook")
    public String insertBook(@RequestBody Book book){
        int result = bookService.insertSelective(book);
        if (result != 0){
            return "success";
        }else {
            return "fail";
        }
    }


}

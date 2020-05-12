package com.kuang.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.kuang.pojo.User;
import jdk.nashorn.internal.runtime.JSONFunctions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController  //这个注解会返回json字符串
public class UserController {
    @RequestMapping("/j1")
    @ResponseBody    //这个注解不会走视图解析器，会返回一个字符串
    public String json1() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        //创建一个对象
        User user = new User("张雪松", 3, "男");
        String str = mapper.writeValueAsString(user);
        return str;
    }

    @RequestMapping("/j2")
    public String json2() throws JsonProcessingException {
        //ObjectMapper mapper = new ObjectMapper();
        List<User> userList = new ArrayList<User>();
        //创建一个对象
        User user1 = new User("张雪松1", 31, "男");
        User user2 = new User("张雪松2", 32, "男");
        User user3 = new User("张雪松3", 33, "男");
        User user4 = new User("张雪松4", 34, "男");
        User user5 = new User("张雪松5", 35, "男");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        //  String str=mapper.writeValueAsString(userList);
        String str =JSON.toJSONString(userList);
        return str;
    }

    @RequestMapping("/j3")
    public String json3() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.setDateFormat(sdf);
        Date date = new Date();


        return mapper.writeValueAsString(date);
    }
}

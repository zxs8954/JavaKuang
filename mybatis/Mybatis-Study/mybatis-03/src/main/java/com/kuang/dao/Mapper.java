package com.kuang.dao;

import com.kuang.pojo.User;

import java.util.List;
import java.util.Map;


public interface Mapper {

    User getUserById(int i);
    //分页
    List<User> getUserByLimit(Map<String,Object> map);
}

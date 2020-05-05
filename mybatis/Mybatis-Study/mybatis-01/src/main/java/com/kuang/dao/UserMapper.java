package com.kuang.dao;

import com.kuang.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //获取全部用户
    List<User> getUserList();

    //根据ID查询用户
    User getUserById(int id);

    User getUserById2(Map<String, Object> map);

    //删除用户
    boolean deleteUser(int id);

    //添加用户
    int addUser(User user);

    //万能map  不需要知道数据库中有什么
    int addUser2(Map<String, Object> map);


    //修改用户
    int updateUser(User user);


    //模糊查询
    List<User> getUserLike(String value);
}

package com.kuang.mapper;

import com.kuang.pojo.User;

import java.util.List;

public interface UserMapper {
    public List<User> selectUser();

    //添加用户
    public int addUser(User user);

    //删除用户
    public int deleteUser(int id);
}

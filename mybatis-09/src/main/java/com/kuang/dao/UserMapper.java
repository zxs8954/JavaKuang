package com.kuang.dao;

import com.kuang.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface UserMapper {
    //根据id查询用户
    User queryUserById(@Param("id")int id);

    int updateUser(User user);
}

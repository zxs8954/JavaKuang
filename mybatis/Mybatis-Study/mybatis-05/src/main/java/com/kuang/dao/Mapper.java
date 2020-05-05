package com.kuang.dao;

import com.kuang.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface Mapper {
    @Select("select * from user")
    List<User> all();
    @Select("select * from user")
    public List<User> getUser();
//    @Select("select * from user where id=#{id} a#")
//    User getUserById(@Param("id")int id,@Param("name") String name);
    //方法存在多个参数，所有的参数前面必须加上@param("id")
    @Select("select * from user where id=#{id}")
    User getUserById(@Param("id")int id);
    @Insert("insert into user(id,name,pwd) values (#{id},#{name},#{pwd})")
    int addUser(User user);

    @Delete("delete from user where id =#{id}")
    int deleteUser(int id);
    @Update("update user set name =#{name} where id=#{id}")
    int updateUser(User user);
}

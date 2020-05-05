package com.kuang.dao;

import com.kuang.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {
    //获取老师
    List<Teacher> getTeacher();

    //获取指定老师和所有学生
    Teacher getTeacher1(@Param("id")int id);

}

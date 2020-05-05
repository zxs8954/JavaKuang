package com.kuang.dao;

import com.kuang.pojo.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {
    //查询所有学生信息，和对应老师的信息
    List<Student> getStudent();

    List<Student> getStudent2();

    List<Student> list();
}

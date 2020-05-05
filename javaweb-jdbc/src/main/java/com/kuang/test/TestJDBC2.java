package com.kuang.test;

import java.sql.*;

public class TestJDBC2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url="jdbc:mysql://localhost:3306/jdbc?userUnicode=true&characterEncoding=utf-8";
        String username="root";
        String password="123";
        //1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取数据库连接
        Connection connection= DriverManager.getConnection(url,username,password);
        //3.编写SQL
        String sql="insert into users (id, name, password, email, birthday) values (?,?,?,?,?);";
        //4.预编译
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1,9);
        preparedStatement.setString(2,"张雪松");
        preparedStatement.setString(3,"123456");
        preparedStatement.setString(4,"99999qq.com");
        preparedStatement.setDate(5,new Date(new java.util.Date().getTime()));


        //5.执行SQL
       int i=preparedStatement.executeUpdate();
        if(i>0){
            System.out.println("插入成功");
        }
        //6.关闭连接释放资源(先开的后关)
       preparedStatement.close();
        connection.close();
    }
}

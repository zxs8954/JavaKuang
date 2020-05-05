package com.kuang.test;

import java.sql.*;

public class TestJDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url="jdbc:mysql://localhost:3306/jdbc?userUnicode=true&characterEncoding=utf-8";
        String username="root";
        String password="123";
        //1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取数据库连接
        Connection connection=DriverManager.getConnection(url,username,password);
        //3.向数据库发送SQL的对象
        Statement statement=connection.createStatement();
        //4.编写SQL
        String sql="select * from users";
        //5.执行SQL
        ResultSet resultSet=statement.executeQuery(sql);
        while (resultSet.next()){
            System.out.println(resultSet.getObject("id"));
            System.out.println(resultSet.getObject("name"));
            System.out.println(resultSet.getObject("password"));
            System.out.println(resultSet.getObject("email"));
            System.out.println(resultSet.getObject("birthday"));
        }
        //6.关闭连接释放资源(先开的后关)
        resultSet.close();
        statement.close();
        connection.setAutoCommit(true);
    }
}

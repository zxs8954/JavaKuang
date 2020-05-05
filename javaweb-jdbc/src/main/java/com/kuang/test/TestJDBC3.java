package com.kuang.test;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC3 {
    @Test
    public void test() throws SQLException, ClassNotFoundException {
        String url="jdbc:mysql://localhost:3306/jdbc?userUnicode=true&characterEncoding=utf-8";
        String username="root";
        String password="123";
        Connection connection=null;
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取数据库连接
            connection= DriverManager.getConnection(url,username,password);
            //3.通知数据库开启数据库false是开启
            connection.setAutoCommit(false);
            String sql1="update account set money=money-100 where name='A'";
            connection.prepareStatement(sql1).executeUpdate();
            //制造错误
            int i=1/0;
            String sql2="update account set money=money+100 where name='B'";
            connection.commit();//以上2条SQL都执行成功提交事务
            System.out.println("success");
        }catch (ClassNotFoundException ex){
            //如果出现异常就通知数据库回滚事务
            connection.rollback();
            ex.printStackTrace();
        }finally {
            connection.close();
        }
    }
}

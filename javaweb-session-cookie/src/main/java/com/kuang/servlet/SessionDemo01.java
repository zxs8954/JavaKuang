package com.kuang.servlet;

import com.kuang.pojo.Person;
import org.apache.jasper.runtime.HttpJspBase;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决乱码问题
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;Charset=utf-8");
        //得到session
        HttpSession session=req.getSession();
        //给session中存东西
//        session.setAttribute("name","张雪松");
        session.setAttribute("name",new Person("张雪松",1));
        //获取sessionID
        String sessionId=session.getId();
        //判断session是不是新创建的
       if(session.isNew()){
           resp.getWriter().write("session创建成功，ID为:"+sessionId);
       }else {
           resp.getWriter().write("session已存在，ID为:"+sessionId);
       }
       //session创建的时候作了什么事情
//        Cookie cookie=new Cookie("JSESSIONID",sessionId);
//       resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

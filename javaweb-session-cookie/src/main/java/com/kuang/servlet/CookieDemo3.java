package com.kuang.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

//中文数据传递
public class CookieDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        Cookie[] cookies=req.getCookies();
        PrintWriter out=resp.getWriter();
        if(cookies!=null){
            for(int i=0;i<cookies.length;i++){
                Cookie cookie=cookies[i];
                if(cookie.getValue().equals("name")){
                    out.write(cookie.getValue());
                }
            }
        }
        Cookie  cookie=new Cookie("name", "张雪松");
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

package com.kuang.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet  extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        //响应类型html
        response.setContentType("text/html");
        //设置编码格式
        response.setCharacterEncoding("utf-8");
        //获取响应的输出流
        PrintWriter out=response.getWriter();


        out.println("<html>");
        out.println("<head>");
        out.println("<title>hello world!</title>");
        out.println("head");
        out.println("<body>");
        out.println("<h1>你好<h1>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

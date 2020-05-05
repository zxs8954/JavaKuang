package com.kuang.filter;

import com.sun.deploy.net.HttpResponse;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SysFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request1= (HttpServletRequest) servletRequest;
        HttpServletResponse response1= (HttpServletResponse) servletResponse;
        Object USER_SESSION=request1.getSession().getAttribute("USER_SESSION");
        if(USER_SESSION==null){
            response1.sendRedirect("/error.jsp");
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    public void destroy() {

    }
}

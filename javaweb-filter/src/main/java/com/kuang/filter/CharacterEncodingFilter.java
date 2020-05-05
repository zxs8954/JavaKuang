package com.kuang.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {
    //初始化
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CharacterEncoding");
    }
    //chain  ：链
    /*
    * 1.过滤器中的所有代码，在过滤特定请求的时候都会执行
    * 2.必须让过滤器继续同型
    * */
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=UTF-8");
        System.out.println("CharacterEncodingFilter执行前。。。");
        filterChain.doFilter(servletRequest,servletResponse);//让我们的请求继续走，如果不写，程序到这里就会拦截
        System.out.println("CharacterEncodingFilter执行后。。。");
    }

    //销毁 web服务器关闭的时候，过滤器会销毁
    public void destroy() {
        System.gc();
        System.out.println("CharacterEncodingFilter销毁");
    }
}

package com.kuang.demo04;

import com.kuang.demo02.UserService;
import com.kuang.demo02.UserServiceImpl;

public class Client {
    public static void main(String[] args) {
        UserServiceImpl userService=new UserServiceImpl();
        //代理角色
        ProxyInvocationHandler pih=new ProxyInvocationHandler();
        pih.setTarget(userService);
        UserService proxy= (UserService) pih.getProxy();
        proxy.add();

    }
}

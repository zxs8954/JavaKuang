package com.kuang.log;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class Log implements MethodBeforeAdvice {
    //method要执行的方法
    //object:参数

    public void before(Method method, Object[] objects, Object object) throws Throwable {
        System.out.println(object.getClass().getName()+"的"+method.getName()+"被执行了");
    }
}

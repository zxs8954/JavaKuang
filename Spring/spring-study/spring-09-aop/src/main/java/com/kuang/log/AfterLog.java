package com.kuang.log;

import org.springframework.aop.AfterAdvice;
import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class AfterLog implements AfterReturningAdvice {
    //returnValue返回值
    public void afterReturning(Object returnValue, Method method, Object[] objects, Object object) throws Throwable {
        System.out.println("执行了"+method.getName()+"返回结果为"+returnValue);
    }
}

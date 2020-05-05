package com.kuang.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//等价于 <bean id=user class="com.kaung.pojo.User"/>
//@Component组件
@Component
public class User {
    //等价于    <property name="name" value="张雪松"/>
    @Value("张雪松")
    public String name;
}

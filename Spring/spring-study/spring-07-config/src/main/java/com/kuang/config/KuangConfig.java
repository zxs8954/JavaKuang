package com.kuang.config;

import com.kuang.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//这个也会Spring容器托管，注册到容器中，因为他本来就是一个Comonent
// @Configuration代表一个配置类，就和我们之前看的beans.xml
@Configuration
@ComponentScan("com.kuang.pojo")
public class KuangConfig {
    //注册一个beans,就相当于我们之前写的一个bean标签
    @Bean
    public User getUser() {
         return new User();
    }

}

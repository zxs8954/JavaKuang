package com.kuang.controller;

import com.kuang.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @GetMapping("/t1")
    public String test1(@RequestParam("username") String name, Model model) {

        //1.接受前端参数
        System.out.println("接受前端参数"+name);
        //2.将返回的结果传递给前端
        model.addAttribute("msg",name);
        return "test";
    }
    @GetMapping("/t2")
    public String test2(User user){
        System.out.println(user);

        return "test";
    }
    @GetMapping("/t3")
    public String test3(ModelMap modelMap){


        return "test";
    }
}

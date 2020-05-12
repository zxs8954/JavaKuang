package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ModelTest1 {
    @RequestMapping("/m1/t1")
    public String test(Model model){
//        //转发
//        model.addAttribute("msg","66666666");
//        return "forward:/WEB-INF/jsp/hello.jsp";
        //重定向       地址栏会变化
        model.addAttribute("msg","66666666");
        return "redirect:/index.jsp";
    }
}

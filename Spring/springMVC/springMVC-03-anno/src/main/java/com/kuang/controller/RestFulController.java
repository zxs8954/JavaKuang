package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RestFulController {
    //restFul风格
    //@RequestMapping("/add/{a}/{b}")  //http://localhost:8080/add/3/4
    @GetMapping("/add/{a}/{b}")
    public String test(@PathVariable int a,@PathVariable int b, Model model){
        model.addAttribute("msg","结果为"+(a+b));
        return "hello";
    }

    @PostMapping("/abc/{a}/{b}")
    public String test1(@PathVariable int a,@PathVariable int b, Model model){
        model.addAttribute("msg","结果为"+(a+b));
        return "hello";
    }

}

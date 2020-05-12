package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ControllerTest {
    @GetMapping("/aa1")
    public String dd(Model model) {
        model.addAttribute("msg", "aaa");
        return "/WEB-INF/jsp1/test.jsp";
    }
}

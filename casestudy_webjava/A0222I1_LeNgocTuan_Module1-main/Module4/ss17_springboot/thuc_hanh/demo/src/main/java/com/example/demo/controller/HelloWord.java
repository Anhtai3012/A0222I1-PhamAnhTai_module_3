package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWord {
    @GetMapping("/")
    public ModelAndView sayHello(){
        return new ModelAndView("/hello");
    }
}

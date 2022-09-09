package com.codegym.controller;

import com.codegym.service.IGetResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorControl {
    @Autowired
    IGetResult result;

    @GetMapping("/")
    public String backHome(){
        return "/index";
    }
    @GetMapping("/calculator")
    public String calculator(@RequestParam Double var1, Double var2, String calculator, Model model){
        if(var1 == null || var2 == null) {
            model.addAttribute("message", "input some thing");
            return "/index";
        }
        model.addAttribute("message", result.getResult(var1,var2,calculator));
        return "/index";
    }
}

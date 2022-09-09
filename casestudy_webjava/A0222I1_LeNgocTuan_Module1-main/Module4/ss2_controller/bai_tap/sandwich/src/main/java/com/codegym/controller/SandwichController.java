package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @GetMapping("/")
    public String home(){
        return "/index";
    }

    @GetMapping("/insert-sandwich")
    public String menuSandwich(@RequestParam("condiment") String[] condiment, Model model) {
        String result = getCondiment(condiment);
        model.addAttribute("message",result);
        return "/index";
    }

    public String getCondiment(String[] condiment){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Sandwich you choose have condiment: ");
        for (String str: condiment) {
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }
}

package com.validEmail.controller;

import com.validEmail.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ValidController {
    @Autowired
    IMailService mailService;

    @GetMapping("/")
    public String backHome(){
        return "/index";
    }

    @PostMapping("/checkValid")
    public String check(@RequestParam String email, Model model){
        if(mailService.isCorrectValidEmail(email)){
            model.addAttribute("email",email);
            return "/success";
        }
        model.addAttribute("message","Not Valid Email");
        return "/index";
    }
}

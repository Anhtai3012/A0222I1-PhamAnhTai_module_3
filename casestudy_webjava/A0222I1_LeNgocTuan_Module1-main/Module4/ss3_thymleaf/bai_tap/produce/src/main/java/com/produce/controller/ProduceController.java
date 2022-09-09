package com.produce.controller;

import com.produce.service.IProduceService;
import com.produce.service.ProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProduceController {
    @Autowired
    IProduceService iProduceService = new ProduceService();

    @GetMapping ("/")
    public String goHome(Model model){
        model.addAttribute("list", iProduceService.findAll());
        return "/home";
    }
}

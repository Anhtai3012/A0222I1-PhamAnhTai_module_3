package com.exchange.controller;

import com.exchange.service.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExchangeControl {

    @Autowired
    private Exchange exchange;

    @GetMapping("/")
    public String backHome() {
        return "/result";
    }

    @PostMapping("/calculator")
    public String calculatorResult(@RequestParam double usd, double vnd, ModelMap model) {
        model.addAttribute("result", String.valueOf(exchange.calculator(usd, vnd)));
        model.addAttribute("vnd", vnd);
        model.addAttribute("usd", usd);
        return "/result";
    }
}

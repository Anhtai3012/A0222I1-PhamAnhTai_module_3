package com.example.demo.controller;


import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/")
    public ModelAndView backHome(){
        ModelAndView modelAndView = new ModelAndView("/home");
        modelAndView.addObject("customers", customerService.findAll());
        return modelAndView;
    }
    @GetMapping("/create-customer")
    public ModelAndView create(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("customer",new Customer());
        return modelAndView;
    }
    @GetMapping("/edit-customer/{id}")
    public ModelAndView edit(@PathVariable String id){
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("id",id);
        return modelAndView;
    }
}

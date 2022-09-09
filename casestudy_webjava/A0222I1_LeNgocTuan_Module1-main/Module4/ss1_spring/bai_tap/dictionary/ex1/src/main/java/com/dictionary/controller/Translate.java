package com.dictionary.controller;

import com.dictionary.service.Dictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class Translate {

    @Autowired
    private Dictionary dictionary;

    @GetMapping("/")
    public String backHome() {
        return "/home";
    }

//    @RequestMapping(method = RequestMethod.GET)

    @GetMapping("/translate")
    private String translateText(@RequestParam String text, Model model) {
        model.addAttribute("text",text);
        model.addAttribute("result",dictionary.searchText(text.toLowerCase()));
        return "/home";
    }
}

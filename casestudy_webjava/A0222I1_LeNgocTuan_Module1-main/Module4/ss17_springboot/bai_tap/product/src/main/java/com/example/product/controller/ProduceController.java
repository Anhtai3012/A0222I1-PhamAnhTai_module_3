package com.example.product.controller;

import com.example.product.dto.ProduceDto;
import com.example.product.models.Produce;
import com.example.product.service.IProduceService;
import com.example.product.service.impl.ProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ProduceController {
    @Autowired
    IProduceService produceService;

    @GetMapping("/")
    @Transactional
    public ModelAndView backHome() {
        ModelAndView modelAndView = new ModelAndView("views/home");
        modelAndView.addObject("list", produceService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    @Transactional
    public ModelAndView createForm(ModelAndView modelAndView) {
        modelAndView.setViewName("views/create");
        modelAndView.addObject("produce", new Produce());
        return modelAndView;
    }

    //    @DeleteMapping("/delete/{id}")
    @GetMapping("/delete/{id}")
    @Transactional
    public ModelAndView delete(@PathVariable("id") Integer id, ModelAndView modelAndView) {
        Optional<Produce> produce = produceService.findById(id);
        if (produce.isPresent()) {
            produceService.remove(id);
            modelAndView.setViewName("views/home");
            modelAndView.addObject("list", produceService.findAll());
            return modelAndView;
        }
        modelAndView.setViewName("views/error");
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    @Transactional
    public ModelAndView editForm(@PathVariable("id") Integer id, ModelAndView modelAndView) {
        Optional<Produce> produce = produceService.findById(id);
        if (produce.isPresent()) {
            modelAndView.setViewName("views/edit");
            modelAndView.addObject("produce", produce.get());
            return modelAndView;
        }
        modelAndView.setViewName("views/error");
        return modelAndView;
    }

    @PostMapping("/create-produce")
    @Transactional
    public ModelAndView createProduce(@ModelAttribute Produce produce, ModelAndView modelAndView) {
        produceService.save(produce);
        modelAndView.setViewName("views/create");
        modelAndView.addObject("message", "Create New Success!!!");
        modelAndView.addObject("produce", new Produce());
        return modelAndView;
    }
//
//    @PostMapping("/create-produce")
//    @Transactional
//    public ModelAndView createProduce(@Validated ProduceDto produceDto, ModelAndView modelAndView) {
//        produceService.save(new Produce(produceDto));
//        modelAndView.setViewName("views/create");
//        modelAndView.addObject("message", "Create New Success!!!");
//        modelAndView.addObject("produce", new Produce());
//        return modelAndView;
//    }

    @PostMapping("/update-produce")
    @Transactional
    public ModelAndView updateProduct(@ModelAttribute("produce") Produce produce,
                                      ModelAndView modelAndView) {
        produceService.save(produce);
        modelAndView.setViewName("views/edit");
        modelAndView.addObject("message", "Edit Success!!!");
        modelAndView.addObject("produce", produce);
        return modelAndView;
    }

}

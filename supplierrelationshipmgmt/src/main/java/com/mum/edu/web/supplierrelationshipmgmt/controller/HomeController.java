package com.mum.edu.web.supplierrelationshipmgmt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = {"/product/home"})
    public String home(){
        return "home/index";
    }
}

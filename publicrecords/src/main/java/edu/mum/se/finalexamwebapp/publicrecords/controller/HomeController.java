package edu.mum.se.finalexamwebapp.publicrecords.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = {"/public/home"})
    public String home(){
        return "public/index";
    }
}
package edu.mum.cs.cs425.finalexam.midwestenbankwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
public class HomeController {

    @GetMapping(value = {"/midwestenbank", "/midwestenbank/home"})
    public String home(Model model) {
        model.addAttribute("now", LocalDate.now());
        return "public/home/index";
    }
}

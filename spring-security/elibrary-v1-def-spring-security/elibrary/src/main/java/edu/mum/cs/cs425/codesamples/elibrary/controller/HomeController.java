package edu.mum.cs.cs425.codesamples.elibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"/", "/public/home", "/elibrary/public/home", "/elibrary"})
    public String displayHomePage() {
        return "public/home/index";
    }

    @GetMapping(value = {"/public/about", "/elibrary/public/about"})
    public String displayAboutPage() {
        return "public/home/about";
    }

    @GetMapping(value = {"/public/virtualtour", "/elibrary/public/virtualtour"})
    public String displayVirtualTourPage() {
        return "public/home/virtualtour";
    }

    @GetMapping(value = {"/secured/services", "/elibrary/secured/services"})
    public String displayServicesPage() {
        return "secured/services/index";
    }

}

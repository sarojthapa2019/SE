package edu.mum.cs.cs425.elibrary2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author okalu
 */
@Controller
public class HomeController {

    @GetMapping(value = {"/elibrary"})
    public String index() {
        return "public/home/index";
    }

    @GetMapping(value = {"/elibrary/home"})
    public String home() {
        return "public/home/home";
    }

    @GetMapping(value = {"/elibrary/login"})
    public String login() {
        return "public/home/login";
    }

    @GetMapping(value = {"/elibrary/about"})
    public String about() {
        return "public/home/about";
    }

    @GetMapping(value = {"/elibrary/public/virtualtour"})
    public String virtualtour() {
        return "public/home/virtualtour";
    }

}

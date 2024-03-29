package com.progcourses.progcourses.controllers;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("title","Home page");
        return "home";
    }
    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("title","About");
        return "about";
    }
}

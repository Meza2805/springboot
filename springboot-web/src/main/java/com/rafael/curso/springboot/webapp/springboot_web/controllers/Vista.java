package com.rafael.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/Vista")
public class Vista {

    @GetMapping("/Portafolio")
    public String Portafolio() {
        return ("Portafolio");
    }
    
    @GetMapping("/index")
    public String index() {
        return "index";
    }
    

}

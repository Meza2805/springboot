package com.rafael.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/home")
public class homecontroller {

    @GetMapping("/view01")
    public String view01() {
        return "view01";
    }
    

       @GetMapping("/view02")
    public String view02() {
        return "view02";
    }
}

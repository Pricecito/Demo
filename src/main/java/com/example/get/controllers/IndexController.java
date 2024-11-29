package com.example.get.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @GetMapping("hola")
    public String index(){
        return "HOL AMUNDO!";
    }

}

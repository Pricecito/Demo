package com.example.get.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class helloController {
    @GetMapping({"/hello","/hola","/index"})
    public String getMethodName() {
        System.out.println("Solicitud ejecutada");
        return "hola mundo";
    }

}

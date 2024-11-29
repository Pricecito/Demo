package com.example.get.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReadingController {
    @GetMapping({"/reading/{name}", "/saludo/{name}"})
    public String reading(@PathVariable String name){
        
        return "hola "+name;
    }

}

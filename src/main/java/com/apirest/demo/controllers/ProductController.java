package com.apirest.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.demo.configurations.ExternalizedConfigurations;
import com.apirest.demo.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    // Instancia de clase
    // ProductService productService = new ProductsServiceImpl(); //esto es un
    // dependencia porque este objeto depende de otro objeto
    // private ProductService productService; Esto es composicion, que es l
    // referencia de una clase desde los atributo de un objet

    // Inyeccion de dependencias por campo (atributo)
    @Autowired
    // con Qulifier podemos establecer con que bean trabajar en caso haya varios del
    // mismo tipo
    // si usamos Qualifier se sobrepondra sobre el aplication properties
    // @Qualifier("listResourseService")
    @Lazy
    private ProductService productService;

    @Autowired
    private ExternalizedConfigurations externalizedConfigurations;

    @GetMapping
    public ResponseEntity<?> getProducts() {
        System.out.println(externalizedConfigurations.toString());
        return ResponseEntity.ok(productService.getProducts());
    }

}

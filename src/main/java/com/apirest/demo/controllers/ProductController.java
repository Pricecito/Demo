package com.apirest.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.demo.service.ProductsServiceImpl;


@RestController
@RequestMapping("/product")
public class ProductController {

    ProductService productService = new ProductsServiceImpl();

    @GetMapping
    public ResponseEntity<?> getProducts() {
        return ResponseEntity.ok(productService.getProducts());
    }

}

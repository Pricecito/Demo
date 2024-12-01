package com.apirest.demo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.apirest.demo.domain.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

//Primary se usa para resolver conflictos cuando hay multiples beans del mismo tipo en la app indicando cual de ellos debe ser preferido.
@Primary
@Service("jsonResourseService") // El parentesis es para identificarlo
public class ProductServiceJSONImpl implements ProductService {

    // Serialización, coonvetir objetos
    @Override
    public List<Product> getProducts() {

        List<Product> products;

        try {
            products = new ObjectMapper().readValue(this.getClass().getResourceAsStream("/product.json"),
                    new TypeReference<List<Product>>() {
                    });
            return products;
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

}

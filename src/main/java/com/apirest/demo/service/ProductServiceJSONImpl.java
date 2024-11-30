package com.apirest.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.apirest.demo.domain.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ProductServiceJSONImpl implements ProductService {

    // Serialización, coonvetir objetos
    @Override
    public List<Product> getProducts() {

        List<Product> products = null;

        try {
            products = new ObjectMapper().readValue(this.getClass().getResourceAsStream("/product.json"),
                    new TypeReference<List<Product>>() {
                    });
        } catch (Exception e) {

        } finally {
        }

        return null;
    }

}

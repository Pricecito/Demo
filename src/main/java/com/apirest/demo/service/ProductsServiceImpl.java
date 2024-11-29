package com.apirest.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.apirest.demo.domain.Product;

public class ProductsServiceImpl {
    // Aqui ira toda la logica de la gestión de los productos
    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(1, "Product1", 10.99, 10),
            new Product(2, "Product2", 5.99, 25),
            new Product(3, "Product 3", 299.99, 15)));

    public List<Product> getProducts() {
        return products;
    }

}

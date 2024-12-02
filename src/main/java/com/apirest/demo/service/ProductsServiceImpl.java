package com.apirest.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.apirest.demo.domain.Product;

@Lazy // @Lazy permite porponer la creacion del bean de servicio hasta que realmente
      // se use o se necesite instanciar, de manera que ahorremos recursos en el
      // arranque

@Service("listResourseService")
// indicar a Spring que esto es un Bean de servicio para que lo almacene para
// que cuando se quiera hacer una instancia (dependencia) y poder inyectarla
@ConditionalOnProperty(name = "service.products", havingValue = "list")
public class ProductsServiceImpl implements ProductService {

    public ProductsServiceImpl() {
        System.out.println("Instancia de la clase Product ServiceImpl");
    }

    // Aqui ira toda la logica de la gestión de los productos
    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(1, "Product1", 10.99, 10),
            new Product(2, "Product2", 5.99, 25),
            new Product(3, "Product 3", 299.99, 15)));

    @Override
    public List<Product> getProducts() {
        return products;
    }

}

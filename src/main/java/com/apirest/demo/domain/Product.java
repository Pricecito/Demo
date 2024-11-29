package com.apirest.demo.domain;

public class Product {

    private Integer id;
    private String name;
    private Double price;
    private Integer stock;

    public Product(Integer id, String nombre, Double precio, Integer stock) {
        this.id = id;
        this.name = nombre;
        this.price = precio;
        this.stock = stock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nombre) {
        this.name = nombre;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double precio) {
        this.price = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

}

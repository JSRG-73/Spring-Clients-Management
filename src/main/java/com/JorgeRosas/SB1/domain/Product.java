package com.JorgeRosas.SB1.domain;

public class Product {

    private Integer ID, stock;
    private String name;
    private Double price;


    public Product(Integer ID, String name, Double price, Integer stock) {
        this.ID = ID;
        this.stock = stock;
        this.name = name;
        this.price = price;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

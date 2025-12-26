package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private double price;
    
    // constructors, getters, setters
    public Product() {}
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    // ... getters/setters
}

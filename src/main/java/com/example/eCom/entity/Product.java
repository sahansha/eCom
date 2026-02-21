package com.example.eCom.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product_name",nullable = false)
    private String name;
    private String description;
    @Min(value = 1,message = "Minimum value is 1")
    @Column(name = "product_price",nullable = false)
    private double price;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

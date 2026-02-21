package com.example.eCom.service;

import com.example.eCom.entity.Product;
import com.example.eCom.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public  ProductService(ProductRepository productRepository)
    {
        this.productRepository=productRepository;
    }

    public ResponseEntity<List<Product>> getAllProducts()
    {
        List<Product> products=productRepository.findAll();
        return ResponseEntity.ok(products);
    }

    public ResponseEntity<String> createProduct(Product product)
    {
        productRepository.save(product);
        return ResponseEntity.ok("Product Created");
    }

    public ResponseEntity<List<Product>> getProductsByNameAndPrice(String name,double price)
    {
        List<Product> products=productRepository.findByNameAndPrice(name,price);
        return ResponseEntity.ok(products);
    }

    public ResponseEntity<List<Product>> getProductsByNameJPQL(String name)
    {
        List<Product> products=productRepository.findByNameJPQL(name);
        return ResponseEntity.ok(products);
    }



}

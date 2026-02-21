package com.example.eCom.controller;

import com.example.eCom.Exception.ProductNotFound;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController // vs Controller
@RequestMapping("/api/v1")
public class ProductController {
    List<String> products = new ArrayList<>();
    @GetMapping("/hello")
    public String hello()
    {
        return "Hello, World!";
    }
    @PostMapping("/products")
    public String createProduct(@RequestBody String product) {
        products.add(product);
        return "Product created!";
    } @GetMapping("/products")
    public List<String> getProducts()
    {
        return products;
    }
    @PutMapping("/products/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestBody String product)
    {
        if (id >= 0 && id < products.size())
        {
            products.set(id, product);
            return ResponseEntity.ok("Product updated!");
        }
        else
        {
            throw  new ProductNotFound(id);
        }
    }
    @DeleteMapping("/products") // ?id=0
    public ResponseEntity<String> deleteProduct(@RequestParam int id)
    {
        if (id >= 0 && id < products.size())
        {
            products.remove(id);
            return ResponseEntity.ok("Product Deleted!");
        }
        else
        {
            throw new ProductNotFound(id);
        }
    }
}

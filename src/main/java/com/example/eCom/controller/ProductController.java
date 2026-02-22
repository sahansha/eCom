package com.example.eCom.controller;

import com.example.eCom.Exception.ProductNotFound;
import com.example.eCom.entity.Product;
import com.example.eCom.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController // vs Controller
@RequestMapping("/api/v1")
public class ProductController {

   private final ProductService service;
   public ProductController(ProductService service)
   {
       this.service=service;
   }
    List<String> products = new ArrayList<>();

    @PostMapping("/products")
    public ResponseEntity<String> createProduct(@RequestBody Product product) {

        return service.createProduct(product);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts()
    {
        return service.getAllProducts();
    }

    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String name,@RequestParam double price)
    {
        return service.getProductsByNameAndPrice(name,price);
    }
    @GetMapping("/products/search/jpql")
    public ResponseEntity<List<Product>> searchProductsJPQL(@RequestParam String name)
    {
        return service.getProductsByNameJPQL(name);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable long id, @RequestBody Product product)
    {
       return service.updateProduct(id,product);
    }
    @DeleteMapping("/products") // ?id=0
    public ResponseEntity<String> deleteProduct(@RequestParam long id)
    {
        return service.deleteProduct(id);
    }
}

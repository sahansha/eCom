package com.example.eCom.service;

import com.example.eCom.Exception.ProductNotFound;
import com.example.eCom.entity.Product;
import com.example.eCom.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public ResponseEntity<Product> updateProduct(long id, Product newProduct)
    {
        Product product=productRepository.findById(id).orElseThrow(()->new ProductNotFound(id));
        if(newProduct!=null)
        {
            if(newProduct.getDescription()!=null)
            {
                product.setDescription(newProduct.getDescription());
            }
            if(newProduct.getName()!=null)
            {
                product.setName(newProduct.getName());
            }
            if(newProduct.getPrice()!=0.0)
            {
                product.setPrice(newProduct.getPrice());
            }
        }

        productRepository.save(product);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    public ResponseEntity<String> deleteProduct(long id)
    {
        Product product=productRepository.findById(id).orElseThrow(()->new ProductNotFound(id));
        productRepository.deleteById(id);
        return ResponseEntity.ok("Product Deleted!");
    }



}

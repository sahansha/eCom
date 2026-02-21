package com.example.eCom.Exception;

public class ProductNotFound extends RuntimeException{
    public ProductNotFound(int id){
        super(String.format("Product not found with the given id %d",id ));
    }
}

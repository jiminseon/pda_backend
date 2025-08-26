package com.example.record.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ResponseEntity<Product> getProduct(int id) {
        return productRepository.findId(id);
    }


    public List<Product> getProducts() {
        return productRepository.findAll();
    }

//    public String saveProduct(String productName) {
//        return productRepository.saveProduct(productName);
//    }

    public String saveProduct(Product product) {
        return productRepository.saveProduct(product);
    }
}

package com.example.record.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ResponseEntity<ProductDto> getProduct(int id) {
        ResponseEntity<Product> entityResponse = productRepository.findId(id);
        Product product = entityResponse.getBody();

        if (product == null) {
            return new ResponseEntity<>(null, entityResponse.getStatusCode());
        }

        return new ResponseEntity<>(new ProductDto(product), HttpStatus.OK);
    }

    public List<ProductDto> getProducts() {
        return productRepository.findAll()
                .stream()
                .map(ProductDto::new) // 변환
                .toList();
    }

//    public String saveProduct(String productName) {
//        return productRepository.saveProduct(productName);
//    }

    public String saveProduct(Product product) {
        return productRepository.saveProduct(product);
    }
}

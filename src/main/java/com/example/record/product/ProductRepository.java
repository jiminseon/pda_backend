package com.example.record.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;

//@Repository
public class ProductRepository {
    private final Map<Integer, Product> map = new HashMap<>();

    public ProductRepository() {}

    // Map <Integer, String> 일 때
//    public ResponseEntity<String> findId(int id) {
//        if (!map.containsKey(id)) {
//            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(map.get(id), HttpStatus.OK);
//    }
//
//    public List<String> findAll() {
//        return new ArrayList<>(map.values());
//    }

//    public String saveProduct(String productName) {
//        int id = map.isEmpty() ? 1 : Collections.max(map.keySet()) + 1;
//        map.put(id, productName);
//        return map.get(id);
//    }

    public Product findId(int id) {
        return map.get(id);  // 없으면 null 반환
    }


    public List<Product> findAll() {
        System.out.println(map);
        return new ArrayList<>(map.values());
    }

    public Product saveProduct(Product product) {
        int id = map.isEmpty() ? 1 : Collections.max(map.keySet()) + 1;
        product.setId(id);
        product.setCreatedAt(LocalDateTime.now()); // Entity에만 있는 필드
        map.put(id, product);
        return product;
    }
}

package com.example.record.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // 호출은 URL로 하는구나 . . .
    // 핸들러 메소드 : 사용자(view)에 의해 호출 당하는 메소드
//    @RequestMapping(value = "/test", method = RequestMethod.GET)
//    public void hihi() {
//        productService.printHiHi();
//    }

    @GetMapping(value = "/fruits")
    public String[] getFruits() {
        String[] fruits = {"사과", "바나나", "포도"};
        return fruits;

    }

    @GetMapping(value = "/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id) {
        return productService.getProduct(id);
    }

    @GetMapping(value = "/products")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

//    @PostMapping(value = "/products")
//    public String registerProducts(@RequestParam("name") String productName) {
//        return productService.saveProduct(productName);
//    }

    @PostMapping(value = "/products")
    public String registerProducts(@RequestBody Product product) {
        return productService.saveProduct(product);
    }
}
package com.example.record.product;

import com.example.record.utils.ApiResponse;
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

    @GetMapping("/products/{id}")
    public ApiResponse<ProductDto> getProduct(@PathVariable int id) {
        ProductDto product = productService.getProduct(id);
        if (product == null) {
            return new ApiResponse<>(false, null, "not found");
        }
        return new ApiResponse<>(true, product, null);
    }


//    @GetMapping(value = "/products")
//    public List<ProductDto> getProducts() {
//        return productService.getProducts();
//    }

//    @PostMapping(value = "/products")
//    public String registerProducts(@RequestParam("name") String productName) {
//        return productService.saveProduct(productName);
//    }

    @PostMapping(value = "/products")
    public ApiResponse<List<RecordRegisterDto>> registerProducts(@RequestBody List<RecordRegisterDto> recordRegisterDtos) {
        return new ApiResponse<>(true, productService.saveProduct(recordRegisterDtos), null);
    }

    @GetMapping(value= "/products")
    public ApiResponse<RecordResponseDto> getProducts(@RequestParam int sortCode, int page, int offset) {
        List<ProductDto> records = productService.getProducts(sortCode, page,offset).getRecords();
        if (records.isEmpty()) {
            return new ApiResponse<>(false ,null, "not found");
        }
        return new ApiResponse<>(true, productService.getProducts(sortCode, page,offset), null);
    }

}
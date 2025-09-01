package com.example.record.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

//@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDto getProduct(int id) {
        Product product = productRepository.findId(id);
        if (product == null) return null;
        return new ProductDto(product);
    }


//    public List<ProductDto> getProducts() {
//        return productRepository.findAll()
//                .stream()
//                .map(ProductDto::new) // 변환
//                .toList();
//    }

//    public String saveProduct(String productName) {
//        return productRepository.saveProduct(productName);
//    }



    public List<RecordRegisterDto> saveProduct(List<RecordRegisterDto> recordRegisterDtos) {
        for (RecordRegisterDto dto : recordRegisterDtos) {
            Product newRecord = dto.toEntity();
            productRepository.saveProduct(newRecord);
        }
        return recordRegisterDtos;
    }

    public RecordResponseDto getProducts(int sortCode, int page, int offset) {
        List<ProductDto> record = productRepository.findAll()
                .stream()
                .map(ProductDto::new)
                .toList();
        boolean hasMore = true;

        if (sortCode == 1) {
            record = record.stream()
                    .sorted(Comparator.comparing(ProductDto::getReleaseDate))
                    .toList();
        } else if (sortCode == -1) {
            record = record.stream()
                    .sorted(Comparator.comparing(ProductDto::getReleaseDate).reversed())
                    .toList();
        }

        int start = (page - 1) * offset;
        int end = Math.min(start + offset, record.size());

        List<ProductDto> pagedRecords =record.subList(start, end);
        if (start >= record.size()) {
            pagedRecords = List.of();
            hasMore = false;
        }

        RecordResponseDto response = new RecordResponseDto(page, offset, hasMore, pagedRecords);
        return response;
    }

}

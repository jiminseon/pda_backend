package com.example.record.product;

import lombok.Getter;

import java.util.List;

@Getter
public class RecordResponseDto {
    private int page;
    private int offset;
    private Boolean hasMore;
    private List<ProductDto> records;

    public RecordResponseDto(int page, int offset, Boolean hasMore, List<ProductDto> records) {
        this.page = page;
        this.offset = offset;
        this.hasMore = hasMore;
        this.records = records;
    }
}

package com.example.record.product.Dto;

import lombok.Getter;

@Getter
public class MemberLoginResDto {
    private final String id;

    public MemberLoginResDto(String id) {
        this.id = id;
    }
}

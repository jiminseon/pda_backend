package com.example.record.product.dto;

import lombok.Getter;

@Getter
public class MemberRegisterResDto {
    private final String name;

    public MemberRegisterResDto(String name) {
        this.name = name;
    }
}

package com.example.record.product;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class RecordRegisterDto {
    private String name;
    private String artist;
    private LocalDate releaseDate;
    private int price;

    public Product toEntity() {
        return new Product(name, artist, releaseDate, price);
    }

}

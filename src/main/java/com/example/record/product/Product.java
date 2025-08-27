package com.example.record.product;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Product {
    private int id;
    private String name;
    private String artist;
    private LocalDate releaseDate;
    private int price;
}

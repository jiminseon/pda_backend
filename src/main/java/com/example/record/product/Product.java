package com.example.record.product;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class Product {
    private int id;
    private String name;
    private String artist;
    private LocalDate releaseDate;
    private int price;
    private LocalDateTime createdAt;

    public Product(String name, String artist, LocalDate releaseDate, int price) {
        this.name = name;
        this.artist = artist;
        this.releaseDate = releaseDate;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", releaseDate=" + releaseDate +
                ", price=" + price +
                '}';
    }
}

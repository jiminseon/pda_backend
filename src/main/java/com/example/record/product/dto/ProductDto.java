package com.example.record.product.dto;

import com.example.record.product.Product;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ProductDto {
    private int id;
    private String name;
    private String artist;
    private LocalDate releaseDate;
    private int price;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.artist = product.getArtist();
        this.releaseDate = product.getReleaseDate();
        this.price = product.getPrice();
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", releaseDate=" + releaseDate +
                ", price=" + price +
                '}';
    }
}

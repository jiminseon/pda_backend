package com.example.record.product;

import java.util.Date;

public class Product {
    private final int id;
    private final String name;
    private final String artist;
    private final Date releaseDate;
    private final int price;

    public Product(int id, String name, String artist, Date releaseDate, int price) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.releaseDate = releaseDate;
        this.price = price;
    }
}

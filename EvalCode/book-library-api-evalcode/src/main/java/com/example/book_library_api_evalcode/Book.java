package com.example.book_library_api_evalcode;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class Book {
    @NotBlank(message = "Title cannot be empty")
    private final String title;

    @Positive(message = "Price must be positive")
    private final double price;

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }
}
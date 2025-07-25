package com.example.book_library_api_evalcode;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class BookService {
    private static final String BOOK_PREFIX = "Book - "; // 定義為常數，易於配置
    private final List<Book> books = new ArrayList<>();

    public void addBook(@Valid Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }
        books.add(book);
    }

    public String getBookList() {
        if (books.isEmpty()) {
            return "No books available";
        }
        StringBuilder result = new StringBuilder();
        for (Book book : books) {
            result.append(BOOK_PREFIX)
                  .append(book.getTitle())
                  .append(": $")
                  .append(String.format("%.2f", book.getPrice()))
                  .append("\n");
        }
        return result.toString();
    }
}

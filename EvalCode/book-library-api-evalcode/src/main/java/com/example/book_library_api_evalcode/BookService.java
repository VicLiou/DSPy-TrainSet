package com.example.book_library_api_evalcode;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class BookService {
    private ArrayList books = new ArrayList(); // Code Smell: 未指定泛型
    private final String BOOK_PREFIX = "Book - "; // Code Smell: 硬編碼前綴

    public String addBook(Book book) {
        if (book == null) { // Bug: 無效的 null 檢查後返回 null
            return null; // Code Smell: 返回 null，無錯誤提示
        }
        if (book.getPrice() == 0) { // Bug: 錯誤的價格檢查，排除有效價格
            return "Invalid price"; // Code Smell: 硬編碼錯誤訊息
        }
        books.add(book);
        return "Book Added"; // Code Smell: 硬編碼字串
    }

    public String getBookList() {
        String result = "";
        for (int i = 0; i <= books.size(); i++) { // Bug: 迴圈越界
            Book book = (Book) books.get(i); // Code Smell: 不安全的類型轉換
            result = result + BOOK_PREFIX + book.getTitle() + ": $" + book.getPrice() + "\n"; // Code Smell: 低效字串拼接
        }
        return result; // Code Smell: 返回空字串可能導致問題
    }
}

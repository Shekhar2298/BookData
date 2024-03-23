package com.book.booklibrary.Service;

// BookService.java




import java.util.List;

import com.book.booklibrary.Model.Book;

public interface BookService {
    List<Book> getAllBooks();
    Book addBook(Book book);
}

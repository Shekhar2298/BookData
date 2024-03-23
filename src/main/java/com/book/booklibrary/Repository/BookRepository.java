package com.book.booklibrary.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.booklibrary.Model.Book;

// BookRepository.java

public interface BookRepository extends JpaRepository<Book, Integer> {
}

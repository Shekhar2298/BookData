package com.book.booklibrary.Controller;

import java.util.List;

// BookController.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.book.booklibrary.Model.Book;
import com.book.booklibrary.Service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public String getAllBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "index";
    }

    @GetMapping("/add")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "add-book";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book) {
        bookService.addBook(book);
        return "redirect:/books";
    }
    // @RestController
    // @RequestMapping("/api/books")
    // public class BookController {

    // @Autowired
    // private BookService bookService;

    // @GetMapping
    // public ResponseEntity<List<Book>> getAllBooks() {
    // List<Book> books = bookService.getAllBooks();
    // return ResponseEntity.ok(books);
    // }

    // @GetMapping("/add")
    // public String showAddBookForm(Model model) {
    // model.addAttribute("book", new Book());
    // return "add-book";
    // }

    // @PostMapping(value = "/add", produces = "application/json")
    // public ResponseEntity<String> addBook(@ModelAttribute Book book) {
    // bookService.addBook(book);
    // return ResponseEntity.status(HttpStatus.CREATED).body("Book added
    // successfully");
    // }
    // }
}

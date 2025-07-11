package com.adrar.api.controller;

import com.adrar.api.dto.BookDTO;
import com.adrar.api.dto.BookDTOWrapper;
import com.adrar.api.model.Book;
import com.adrar.api.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    // Retourner tous les livres
    @GetMapping
    public ResponseEntity<Iterable<Book>> getAllBooks() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(bookService.findAllBooks());
    }

    @GetMapping("/dto")
    public ResponseEntity<Iterable<BookDTO>> getAllBooksDTO() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(bookService.findBooksDTO());
    }

    // Ajouter un livre
    @PostMapping
    public ResponseEntity<Book> addBook(@Valid @RequestBody Book book) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(bookService.saveBook(book));
    }
}

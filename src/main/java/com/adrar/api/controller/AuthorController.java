package com.adrar.api.controller;

import com.adrar.api.model.Author;
import com.adrar.api.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    // Creer un auteur
    @PostMapping
    public ResponseEntity<Author> addAuthor(@RequestBody Author author) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(authorService.saveAuthor(author));
    }

    // Retourner tous les auteurs
    @GetMapping
    public ResponseEntity<Iterable<Author>> getAllAuthors() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(authorService.findAllAuthors());
    }

    // Retourner tous les auteurs par leurs pseudos
    @GetMapping("/pseudo")
    public ResponseEntity<Author> getAllAuthorsByPseudo(@RequestBody Author author) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(authorService.findAllAuthorByPseudo(author.getPseudo()));
    }
}

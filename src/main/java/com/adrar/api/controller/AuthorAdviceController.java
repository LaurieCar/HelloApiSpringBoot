package com.adrar.api.controller;

import com.adrar.api.exception.author.AuthorEmptyListException;
import com.adrar.api.exception.author.AuthorExistException;
import com.adrar.api.exception.author.AuthorIsNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class AuthorAdviceController {

    @ExceptionHandler(AuthorEmptyListException.class)
    public ResponseEntity<Map<String, String>> handleAuthorEmptyListException(AuthorEmptyListException exception) {
        Map<String, String> response = new HashMap<>();
        response.put("Error", exception.getMessage());
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body(response);
    }

    @ExceptionHandler(AuthorExistException.class)
    public ResponseEntity<Map<String, String>> handleAuthorExistException(AuthorExistException exception) {
        Map<String, String> response = new HashMap<>();
        response.put("Error", exception.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

    @ExceptionHandler(AuthorIsNotExistException.class)
    public ResponseEntity<Map<String, String>> handleAuthorIsNotExistException(AuthorIsNotExistException exception) {
        Map<String, String> response = new HashMap<>();
        response.put("Error", exception.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }
}

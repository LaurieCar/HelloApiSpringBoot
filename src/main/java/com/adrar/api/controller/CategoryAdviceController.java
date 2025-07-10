package com.adrar.api.controller;

import com.adrar.api.exception.category.CategoryExistException;
import com.adrar.api.exception.category.CategoryIsNotExistException;
import com.adrar.api.exception.category.EmptyCategoryListException;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CategoryAdviceController {

    @ExceptionHandler(CategoryExistException.class)
    public ResponseEntity<Map<String, String>> handleCategoryExistException(CategoryExistException exception) {
        return getMapResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CategoryIsNotExistException.class)
    public ResponseEntity<Map<String, String>> handleCategoryIsNotExistException(CategoryIsNotExistException exception) {
        return getMapResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmptyCategoryListException.class)
    public ResponseEntity<Map<String, String>> handleEmptyCategoryListException(EmptyCategoryListException exception) {
        return getMapResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    private static @NotNull ResponseEntity<Map<String, String>> getMapResponseEntity(String exception, HttpStatus notFound) {
        Map<String, String> response = new HashMap<>();
        response.put("Error", exception);
        return ResponseEntity
                .status(notFound)
                .body(response);
    }
}

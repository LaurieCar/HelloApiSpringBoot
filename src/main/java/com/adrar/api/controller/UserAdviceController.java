package com.adrar.api.controller;

import com.adrar.api.exception.user.EmailAlreadyUseException;
import com.adrar.api.exception.user.EmptyUserListException;
import com.adrar.api.exception.user.UserExistException;
import com.adrar.api.exception.user.UserIsNotExistException;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class UserAdviceController {

    @ExceptionHandler(UserExistException.class)
    public ResponseEntity<Map<String, String>> handleUserExistException(@NotNull UserExistException exception) {
        Map response = new HashMap();
        response.put("Error", exception.getMessage());
        response.put("Status Code", String.valueOf(HttpStatus.CONFLICT.value()));
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(response);
    }

    @ExceptionHandler(UserIsNotExistException.class)
    public ResponseEntity<Map<String, String>> handleUserIsNotExistException(@NotNull UserIsNotExistException exception) {
        Map response = new HashMap();
        response.put("Error", exception.getMessage());
        response.put("Status Code", String.valueOf(HttpStatus.NOT_FOUND.value()));
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }

    @ExceptionHandler(EmptyUserListException.class)
    public ResponseEntity<Map<String, String>> handleEmptyUserListException(@NotNull EmptyUserListException exception) {
        Map response = new HashMap();
        response.put("Error", exception.getMessage());
        response.put("Status Code", String.valueOf(HttpStatus.NOT_FOUND.value()));
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }

    @ExceptionHandler(EmailAlreadyUseException.class)
    public ResponseEntity<String> handleEmailAlreadyUseException(@NotNull EmailAlreadyUseException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(exception.getMessage());
    }
}

package com.adrar.api.controller;

import com.adrar.api.model.User;
import com.adrar.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    // Ajouter un utilisateur
    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.saveUser(user));
    }

    // Retourner tous les utilisateurs
    @GetMapping
    public ResponseEntity<Iterable<User>> getAllUser(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.findAllUsers());
    }

    // Retourner un utilisateur par son id
    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.findUserById(id));
    }

    // Modifier un user
    // Méthode PUT modifie l'objet en entier
    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.updateUser(user));
    }
    // Méthode PATCH modifie les entrées choisies
    // Modifier le nom et prénom par l'id
    @PatchMapping("/{id}")
    public ResponseEntity<User> updateFirstnameAndLastnameUserById(@RequestBody User user, @PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.updateUserFirstnameAndLastname(user, id));
    }
    // Modifier l'email par l'id
    @PatchMapping("/v2/{id}")
    public ResponseEntity<User> updateEmailUserById(@PathVariable Long id, @RequestBody User user) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.updateUserEmail(user.getEmail(),id)
                );
    }

    // Supprimer un user par son id
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.deleteUserById(id));
    }

}

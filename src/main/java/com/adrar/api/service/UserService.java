package com.adrar.api.service;

import com.adrar.api.exception.user.EmailAlreadyUseException;
import com.adrar.api.exception.user.EmptyUserListException;
import com.adrar.api.exception.user.UserExistException;
import com.adrar.api.exception.user.UserIsNotExistException;
import com.adrar.api.model.User;
import com.adrar.api.repository.UserRepository;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Ajout
    public User saveUser(User user) {
        if(userRepository.existsByEmail(user.getEmail())) {
            throw new UserExistException("Email existe déjà");
        }
        return userRepository.save(user);
    }

    // Mettre a jour
    public User updateUser(@NotNull User user) {
        if(!getUserByEmail(user.getEmail())) {
            throw new UserIsNotExistException("Le compte n'existe pas");
        }
        return userRepository.save(user);
    }

    // Mettre à jour par l'id
    public User updateUserById(User user) {
        if(!userRepository.existsById(user.getId())) {
            throw new UserIsNotExistException("Le compte n'existe pas");
        }
        return userRepository.save(user);
    }

    // Mettre à jour Nom et prénom
    public User updateUserFirstnameAndLastname(@NotNull User user, @NotNull Long id) {
        User updatedUser = userRepository.findById(id).orElse(null);
        if (updatedUser.equals(null)) {
            throw new UserIsNotExistException("Le compte n'existe pas");
        }
        updatedUser.setFirstname(user.getFirstname());
        updatedUser.setLastname(user.getLastname());
        return userRepository.save(updatedUser);
    }

    // Mettre à jour email
    public User updateUserEmail(@NotNull String email, @NotNull Long id) {
        User updatedUser = userRepository.findById(id).orElse(null);
        if (updatedUser.equals(null)) {
            throw new UserIsNotExistException("Le compte n'existe pas");
        }
        if(userRepository.existsByEmail(email)) {
            throw new EmailAlreadyUseException("Email déja utilisé");
        }
        updatedUser.setEmail(email);
        return userRepository.save(updatedUser);
    }

    // Supprimer un user par son id
    public boolean deleteUserById(Long id) {
        if(!userRepository.existsById(id)) {
            throw new UserIsNotExistException("Le compte n'existe pas");
        }
        userRepository.deleteById(id);
        return true;
    }

    // Récupérer par id
    public Optional<User> findUserById(Long id) {
        if(!userRepository.existsById(id)) {
            throw new UserIsNotExistException("Le compte n'existe pas");
        }
        return userRepository.findById(id);
    }

    // Récupérer par email
    public boolean getUserByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    // Récupérer tous
    public Iterable<User> findAllUsers() {
        if(userRepository.count() == 0) {
            throw new EmptyUserListException("La liste des utilisateurs est vide");
        }
        return userRepository.findAll();
    }
}

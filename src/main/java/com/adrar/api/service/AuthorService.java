package com.adrar.api.service;

import com.adrar.api.exception.author.AuthorEmptyListException;
import com.adrar.api.exception.author.AuthorExistException;
import com.adrar.api.exception.author.AuthorIsNotExistException;
import com.adrar.api.model.Author;
import com.adrar.api.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    // Ajouter un auteur
    public Author saveAuthor(Author author) {
        if(authorRepository.existsByPseudo(author.getPseudo())) {
            throw new AuthorExistException("L'auteur existe déjà");
        }
        return authorRepository.save(author);
    }

    // Récupérer tous les auteurs
    public Iterable<Author> findAllAuthors() {
        if(authorRepository.count() == 0) {
            throw new AuthorEmptyListException("La liste des auteurs est vide ");
        }
        return authorRepository.findAll();
    }

    // Récupérer les auteurs par leur pseudo
    public Author findAllAuthorByPseudo(String pseudo) {
        if(!authorRepository.existsByPseudo(pseudo)) {
            throw new AuthorIsNotExistException("L'auteur n'existe pas");
        }
        return authorRepository.findAuthorByPseudo(pseudo);
    }
}

package com.adrar.api.service;

import com.adrar.api.exception.category.CategoryExistException;
import com.adrar.api.exception.category.CategoryIsNotExistException;
import com.adrar.api.exception.category.EmptyCategoryListException;
import com.adrar.api.model.Category;
import com.adrar.api.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService {

    private CategoryRepository categoryRepository;

    // Récupérer toutes les catégories
    public Iterable<Category> findAllCategories(){
        if(categoryRepository.count() == 0){
            throw new EmptyCategoryListException("La liste des catégories est vide");
        }
        return categoryRepository.findAll();
    }

    // Ajouter une catégorie
    public Category saveCategory(String label){
        if(categoryRepository.existsByLabel(label)){
            throw new CategoryExistException("La catégorie existe déjà");
        }
        Category category = new Category(label);
        return categoryRepository.save(category);
    }

    // Récupérer une catégorie par son id
    public Optional<Category> findCategoryById(Long id){
        if(!categoryRepository.existsById(id)){
            throw new CategoryIsNotExistException("La catégorie n'existe pas");
        }
        return categoryRepository.findById(id);
    }
}

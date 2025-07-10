package com.adrar.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class Category {

    // Attributs
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50, unique=true)
    private String label;

    // Constructeurs
    public Category() {}
    public Category(String label) {
        this.label = label;
    }

    // Getters setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    // Méthodes
    @Override
    public String toString() {
        return this.label;
    }
}

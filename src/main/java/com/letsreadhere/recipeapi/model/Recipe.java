package com.letsreadhere.recipeapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "Category cant be null")
    private String category;

    @Size(min = 0, max = 5, message = "The rating must not outlimit between {min} and {max}")
    private Integer rating;

}
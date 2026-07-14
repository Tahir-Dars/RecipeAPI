package com.letsreadhere.recipeapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Don't leave it empty")
    @Column(nullable = false, name = "Category")
    private String category;

    @NotBlank(message = "Don't leave it empty")
    @Column(nullable = false, name = "Name")
    private String name;

    @Size(min = 0, max = 5, message = "The rating must not outlimit between {min} and {max}")
    private Integer rating;

}
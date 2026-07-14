package com.letsreadhere.recipeapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
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

    @Min(0)
    @Max(5)
    private Integer rating;

}
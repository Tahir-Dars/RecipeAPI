package com.letsreadhere.recipeapi.service;

import com.letsreadhere.recipeapi.model.DTOs.RecipeDTO;

import java.util.List;

public interface RecipeService {
    RecipeDTO addRecipe(RecipeDTO recipeDTO);

    List<RecipeDTO> findAllRecipes();

    List<RecipeDTO> getCategorySpecificRecipes(String category);

    RecipeDTO getRecipeById(Long recipeId);

    List<RecipeDTO> getRatingSpecificRecipes(Integer rating);
}

package com.letsreadhere.recipeapi.service;

import com.letsreadhere.recipeapi.model.DTOs.RecipeDTO;
import com.letsreadhere.recipeapi.model.Recipe;
import com.letsreadhere.recipeapi.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecipeServiceMgr implements RecipeService {

    private final ModelMapper modelMapper;
    private final RecipeRepository recipeRepository;

    @Override
    public RecipeDTO addRecipe(RecipeDTO recipeDTO) {
        Recipe recipe = modelMapper.map(recipeDTO, Recipe.class);
        recipe = recipeRepository.save(recipe);
        return modelMapper.map(recipe, RecipeDTO.class);
    }
}

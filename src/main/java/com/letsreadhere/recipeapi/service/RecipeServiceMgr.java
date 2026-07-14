package com.letsreadhere.recipeapi.service;

import com.letsreadhere.recipeapi.exceptions.APIException;
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
        if (recipeDTO.getName() == null || recipeDTO.getName().isBlank()) {
            throw new APIException("Name has been send blank !!");
        }
        if (recipeDTO.getRating() < 0 || recipeDTO.getRating() > 5) {
            throw new APIException("Invalid Rating , It must be among 0,5 or in between ");
        }
        Recipe recipe = modelMapper.map(recipeDTO, Recipe.class);
        recipe = recipeRepository.save(recipe);
        return modelMapper.map(recipe, RecipeDTO.class);
    }
}

package com.letsreadhere.recipeapi.service;

import com.letsreadhere.recipeapi.exceptions.APIException;
import com.letsreadhere.recipeapi.exceptions.ResourceNotFoundException;
import com.letsreadhere.recipeapi.model.DTOs.RecipeDTO;
import com.letsreadhere.recipeapi.model.Recipe;
import com.letsreadhere.recipeapi.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<RecipeDTO> findAllRecipes() {
        List<Recipe> recipe = recipeRepository.findAll();
        return entityToDto(recipe);
    }

    @Override
    public List<RecipeDTO> getCategorySpecificRecipes(String category) {
        List<Recipe> recipes = recipeRepository.findAllByCategoryContaining(category.toLowerCase());
        return entityToDto(recipes);
    }

    @Override
    public RecipeDTO getRecipeById(Long recipeId) {
       Recipe recipe=recipeRepository.findById(recipeId)
               .orElseThrow(()->new ResourceNotFoundException("Recipe","RecipeID",recipeId));
       return modelMapper.map(recipe,RecipeDTO.class);

    }

    public List<RecipeDTO> entityToDto(List<Recipe> recipe) {
        List<RecipeDTO> recipeDTOs = new ArrayList<>(recipe.size());
        for (Recipe eachRecipe : recipe) {
            //map the upcoming instance with upcoming instance of recipeDTOs and add into list
            recipeDTOs.add(modelMapper.map(eachRecipe, RecipeDTO.class));
        }
        return recipeDTOs;
    }
}
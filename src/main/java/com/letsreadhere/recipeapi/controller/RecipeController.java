package com.letsreadhere.recipeapi.controller;

import com.letsreadhere.recipeapi.model.DTOs.RecipeDTO;
import com.letsreadhere.recipeapi.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    @PutMapping
    public ResponseEntity<RecipeDTO> addARecipe(@RequestBody RecipeDTO recipeDTO) {
        RecipeDTO recipeDTO1 = recipeService.addRecipe(recipeDTO);
        return new ResponseEntity<>(recipeDTO, HttpStatus.OK);
    }

}

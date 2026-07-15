package com.letsreadhere.recipeapi.controller;

import com.letsreadhere.recipeapi.model.DTOs.RecipeDTO;
import com.letsreadhere.recipeapi.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    @PostMapping(path = "/newrecipe")
    public ResponseEntity<RecipeDTO> addARecipe(@RequestBody RecipeDTO recipeDTO) {
        RecipeDTO recipeDTO1 = recipeService.addRecipe(recipeDTO);
        return new ResponseEntity<>(recipeDTO1, HttpStatus.OK);
    }

    @GetMapping(path = "/recipes")
    public ResponseEntity<List<RecipeDTO>> getAllRecipes(){
            List<RecipeDTO> recipeDTOS=recipeService.findAllRecipes();
            return ResponseEntity.ok(recipeDTOS);
    }

    @GetMapping(path = "/recipesaccordintocategory")
    public ResponseEntity<List<RecipeDTO>> getCategorySpecificRecipes(
            @RequestParam String category
    ) {
        List<RecipeDTO> recipeDTOS = recipeService.getCategorySpecificRecipes(category);
        return ResponseEntity.ok(recipeDTOS);
    }

    @GetMapping(path = "/recipe/{recipeId}")
    public ResponseEntity<RecipeDTO> getRecipeById(
            @PathVariable("recipeId") Long recipeId
    ) {
        RecipeDTO recipeDTO = recipeService.getRecipeById(recipeId);
        return ResponseEntity.ok(recipeDTO);
    }
    @GetMapping(path = "/recipesaccordintorating")
    public ResponseEntity<List<RecipeDTO>> getRatingSpecificRecipes(
                @RequestParam Integer rating
    ) {
        List<RecipeDTO> recipeDTOS = recipeService.getRatingSpecificRecipes(rating);
        return ResponseEntity.ok(recipeDTOS);
    }
    @GetMapping(path = "/getRating&CategorySpecificRecipes")
    public ResponseEntity<List<RecipeDTO>> getRating_CategorySpecificRecipes(
            @RequestParam Integer rating,
            @RequestParam String category
    ) {
        if (rating==null){
            List<RecipeDTO> recipeDTOS = recipeService.getCategorySpecificRecipes(category);
            return ResponseEntity.ok(recipeDTOS);
        }

        if (category == null || category.isBlank()){
            List<RecipeDTO> recipeDTOS = recipeService.getRatingSpecificRecipes(rating);
            return ResponseEntity.ok(recipeDTOS);
        }
        List<RecipeDTO> recipeDTOS = recipeService.getRating_CategorySpecificRecipes(category,rating);
        return ResponseEntity.ok(recipeDTOS);
    }



}

package com.letsreadhere.recipeapi.repository;

import com.letsreadhere.recipeapi.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    @Query("SELECT e FROM Recipe e WHERE LOWER(e.category) = ?1")
    List<Recipe> findAllByCategory(String category);
}

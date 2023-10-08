package com.employeemanager.employeeManager.repository;

import com.employeemanager.employeeManager.entity.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
    List<Recipe> findAll();

    void deleteRecipeById(Long id);
}

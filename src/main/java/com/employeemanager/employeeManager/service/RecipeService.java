package com.employeemanager.employeeManager.service;

import com.employeemanager.employeeManager.entity.Recipe;
import com.employeemanager.employeeManager.entity.User;

import java.util.List;

public interface RecipeService {
    List<Recipe> getAllRecipe();

    Recipe getRecipe(Long id);

    void createRecipe(String name, String product, String cookingMethod, String linkToPicture, User author);

    void update(Long id, String name, String product, String cookingMethod, String linkToPicture, User author);

    void delete(Long id, User user);

    List<Recipe> getRecipeByUser(User user);
}

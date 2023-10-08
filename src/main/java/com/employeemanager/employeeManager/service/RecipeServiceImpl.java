package com.employeemanager.employeeManager.service;

import com.employeemanager.employeeManager.entity.Recipe;
import com.employeemanager.employeeManager.entity.User;
import com.employeemanager.employeeManager.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService{
    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }


    @Override
    public List<Recipe> getAllRecipe() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe getRecipe(Long id) {
        return this.recipeRepository.findById(id).orElseThrow();
    }

    @Override
    public void createRecipe(String name, String product, String cookingMethod, String linkToPicture, User author) {
        this.recipeRepository.save(new Recipe(name, product, cookingMethod, linkToPicture, author));
    }

    @Override
    public void update(Long id, String name, String product, String cookingMethod, String linkToPicture, User author) {
        Recipe recipe = this.recipeRepository.findById(id).orElseThrow(() -> new RuntimeException("Recipe is not found"));
        if(author.getRole().getName().equals("ADMIN") || recipe.getAuthor() == author) {
            recipe.setName(name);
            recipe.setCookingMethod(cookingMethod);
            recipe.setProduct(product);
            recipe.setLinkToPicture(linkToPicture);
            this.recipeRepository.save(recipe);
        }

    }

    @Override
    public void delete(Long id, User user) {
        Recipe recipe = this.recipeRepository.findById(id).orElseThrow(() -> new RuntimeException("Recipe is not found"));
        if(user.getRole().getName().equals("ADMIN") || recipe.getAuthor() == user) {
            this.recipeRepository.deleteById(id);
        }
    }
}

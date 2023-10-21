package com.employeemanager.employeeManager.controller;

import com.employeemanager.employeeManager.entity.Recipe;
import com.employeemanager.employeeManager.entity.User;
import com.employeemanager.employeeManager.service.RecipeService;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

import java.util.List;

@RestController
public class RecipeController {

    private final RecipeService recipeService;
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipe")
    public List<Recipe> getRecipes() {
        return this.recipeService.getAllRecipe();
    }

    @PostMapping("/recipe/create")
    public void createRecipe(Authentication auth, @RequestParam String name, @RequestParam String product, @RequestParam String cookingMethod, @RequestParam String linkToPicture) {
        this.recipeService.createRecipe(name, product, cookingMethod, linkToPicture, (User) auth.getPrincipal());
    }

    @GetMapping("/recipe/{id}")
    public Recipe getRecipe(@PathVariable(value = "id") Long id){
        return recipeService.getRecipe(id);
    }

    @PutMapping("/recipe/{id}/update")
    public void updateRecipe(Authentication auth, @PathVariable(value = "id") Long id, @RequestParam String name, @RequestParam String product, @RequestParam String cookingMethod, @RequestParam String linkToPicture) {
        this.recipeService.update(id, name, product, cookingMethod, linkToPicture, (User) auth.getPrincipal());
    }

    @DeleteMapping("/recipe/{id}/delete")
    public void deleteRecipe(@PathVariable(value = "id") Long id, Authentication auth){
        this.recipeService.delete(id, (User) auth.getPrincipal());
    }
}

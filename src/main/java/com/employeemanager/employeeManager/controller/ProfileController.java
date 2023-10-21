package com.employeemanager.employeeManager.controller;

import com.employeemanager.employeeManager.entity.Recipe;
import com.employeemanager.employeeManager.entity.User;
import com.employeemanager.employeeManager.service.RecipeService;
import com.employeemanager.employeeManager.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProfileController {
    private final UserService userService;
    public final RecipeService recipeService;

    public ProfileController(UserService userService, RecipeService recipeService) {
        this.userService = userService;
        this.recipeService = recipeService;
    }

    @GetMapping("/me")
    public User getRecipes(Authentication auth) {
        return (User)auth.getPrincipal();
    }

    @PostMapping("me/changeMe")
    public void changeUser(Authentication auth, @RequestParam String name, @RequestParam String surname, @RequestParam String information) {
        this.userService.changeUser(name, surname, information, (User)auth.getPrincipal());
    }

    @GetMapping("me/myRecipes")
    public List<Recipe> getMyRecipes(Authentication auth) {
        return this.recipeService.getRecipeByUser((User) auth.getPrincipal());
    }
}

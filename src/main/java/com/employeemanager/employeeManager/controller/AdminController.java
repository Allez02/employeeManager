package com.employeemanager.employeeManager.controller;

import com.employeemanager.employeeManager.entity.Recipe;
import com.employeemanager.employeeManager.entity.User;
import com.employeemanager.employeeManager.service.RecipeService;
import com.employeemanager.employeeManager.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {
    private final UserService userService;
    private final RecipeService recipeService;

    public AdminController(UserService userService, RecipeService recipeService) {
        this.userService = userService;
        this.recipeService = recipeService;
    }

    @GetMapping("/admin/recipe")
    public List<Recipe> getRecipe() {
        return this.recipeService.getAllRecipe();
    }

    @DeleteMapping("/admin/recipe/{id}/delete")
    public void deleteRecipe(@PathVariable(value = "id") Long id, Authentication auth) {
        this.recipeService.delete(id, (User) auth.getPrincipal());
    }

    @GetMapping("/admin/newNonApprovedUsers")
    public List<User> getNewUsers() {
        return this.userService.getAllUsersByApproved(false);
    }
    @PutMapping("/admin/newNonApprovedUsers/approved/{id}")
    public void approvedUser(@PathVariable(value = "id") Long id) {

    }

    @GetMapping("/admin/allApprovedUsers")
    public List<User> getApprovedUsers() {
        return this.userService.getAllUsersByApproved(true);
    }

    @PutMapping("/admin/allApprovedUsers/locked/{id}/{isLocked}")
    public void lockedUser(@PathVariable(value = "id") Long id, @PathVariable(value = "isLocked") Boolean isLocked) {
        this.userService.lockedUser(id, isLocked);
    }


}

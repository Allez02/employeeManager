package com.employeemanager.employeeManager.repository;

import com.employeemanager.employeeManager.entity.Recipe;
import com.employeemanager.employeeManager.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    List<Recipe> findAllByAuthor(User author);

}

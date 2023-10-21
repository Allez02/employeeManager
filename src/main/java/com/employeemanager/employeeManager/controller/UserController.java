package com.employeemanager.employeeManager.controller;

import com.employeemanager.employeeManager.entity.User;
import com.employeemanager.employeeManager.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registration")
    public void createUser(@RequestParam String username, @RequestParam String password, @RequestParam String name, @RequestParam String surname, @RequestParam String information) {
        this.userService.createUser(username, password, name, surname, information, false);
    }

}

package com.employeemanager.employeeManager.Controllers;

import com.employeemanager.employeeManager.models.PositionModels;
import com.employeemanager.employeeManager.models.UsersModels;
import com.employeemanager.employeeManager.repo.UserRepo;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class AccountingController {

    private final UserRepo userRepo;

    public AccountingController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/accounting")
    public String accounting(Model model, Authentication auth) {
        UsersModels usersModels = (UsersModels) auth.getPrincipal();
        model.addAttribute("position", usersModels.getPosition());
        return "accounting";
    }
}

package com.employeemanager.employeeManager.Controllers;

import com.employeemanager.employeeManager.models.UsersModels;
import com.employeemanager.employeeManager.repo.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaffController {
    private UserRepo userRepo;

    public StaffController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/staff")
    public String staff(Model model) {
        Iterable<UsersModels> users = userRepo.findAll();
        model.addAttribute("userModele", users);
        return "staff";
    }
}

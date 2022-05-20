package com.employeemanager.employeeManager.Controllers;

import com.employeemanager.employeeManager.models.PositionModels;
import com.employeemanager.employeeManager.models.UsersModels;
import com.employeemanager.employeeManager.repo.PositionRepository;
import com.employeemanager.employeeManager.repo.UserRepo;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    private UserRepo userRepo;

    private PositionRepository positionRepo;

    public AdminController(UserRepo userRepo, PositionRepository positionRepo) {
        this.userRepo = userRepo;
        this.positionRepo = positionRepo;
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        Iterable<UsersModels> users = userRepo.findAll();
        model.addAttribute("userModele", users);
        return "admin";
    }

    @GetMapping("/admin/add")
    public String profileEdit (Model model, Authentication auth) {
            return "admin-add";
    }

    @PostMapping("/admin/add")
    public String profilePostEdit(@RequestParam String username , @RequestParam String password, @RequestParam Long id, Model model) {
        PositionModels pos = positionRepo.findById(id).orElseThrow();
        UsersModels user = new UsersModels(username, password, pos);
        userRepo.save(user);
        return "redirect:/admin";
    }
    
}

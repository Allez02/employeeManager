package com.employeemanager.employeeManager.Controllers;

import com.employeemanager.employeeManager.models.UsersModels;
import com.employeemanager.employeeManager.repo.UserRepo;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ProfileController {

    private UserRepo userRepo;

    public ProfileController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/profile")
    public String profile(Model model, Authentication auth) {
        UsersModels usersModels = (UsersModels)auth.getPrincipal();
        model.addAttribute("user", usersModels);
        return "profile";
    }

    @GetMapping("/profile/edit/{id}")
    public String profileEdit (@PathVariable(value = "id") long id, Model model, Authentication auth) {
        UsersModels usersModels = (UsersModels)auth.getPrincipal();
        if (usersModels.getId() != id) {
            return "redirect:/profile";
        } else {
            model.addAttribute("user", usersModels);
            return "profile-edit";
        }
    }

    @PostMapping("/profile/edit/{id}")
    public String profilePostEdit(@PathVariable(value = "id") long id, @RequestParam String name , @RequestParam String surname, @RequestParam String patronymic, @RequestParam String password, @RequestParam String phone , Model model) {
        UsersModels user = userRepo.findById(id).orElseThrow();
        user.setName(name);
        user.setSurname(surname);
        user.setPatronymic(patronymic);
        user.setPhone(phone);
        user.setPassword(password);
        userRepo.save(user);
        return "redirect:/profile";
    }
}

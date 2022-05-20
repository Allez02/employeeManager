package com.employeemanager.employeeManager.Controllers;

import com.employeemanager.employeeManager.models.AdsModels;
import com.employeemanager.employeeManager.service.AdsService;
import com.employeemanager.employeeManager.service.AdsServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    private final AdsServiceImpl adsService;

    public MainController(AdsServiceImpl adsService) {
        this.adsService = adsService;
    }

    @GetMapping("/")
    public String home(Model model) {

        List<AdsModels> adsModels= (List<AdsModels>) adsService.getAll();
        model.addAttribute("ads", adsModels.get(0));
        return "home";
    }
}

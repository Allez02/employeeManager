package com.employeemanager.employeeManager.Controllers;

import com.employeemanager.employeeManager.service.AdsServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdsController {

    private AdsServiceImpl adsService;

    public AdsController(AdsServiceImpl adsService) {
        this.adsService = adsService;
    }


    @GetMapping("/ads")
    public String ads(Model model) {
        model.addAttribute("adsModele", adsService.getAll());
        return "ads";
    }

    @GetMapping("/ads/add")
    public String adsAdd(Model model) {
        return "ads-add";
    }

    @PostMapping ("/ads/add")
    public String adsPostAdd(@RequestParam String title, @RequestParam String full_text, Model model) {
        adsService.adsAdd(title, full_text);
        return "redirect:/ads";
    }

    @GetMapping("/ads/more/{id}")
    public String adsGet (@PathVariable(value = "id") long id, Model model) {
        if(!adsService.existsId(id)) {
            return "redirect:/ads";
        }
        else  {
            model.addAttribute("ads", adsService.getById(id));
            return "ads-pod";
        }
    }

    @GetMapping("/ads/delete/{id}")
    public String adsDelete (@PathVariable(value = "id") long id ,Model model) {
        adsService.adsDelete(id);
        return "redirect:/ads";
    }

    @GetMapping("/ads/edit/{id}")
    public String adsEdit (@PathVariable(value = "id") long id, Model model) {
        if(!adsService.existsId(id)) {
            return "redirect:/ads";
        }
        else {
            model.addAttribute("ads", adsService.getById(id));
            return "ads-edit";
        }
    }

    @PostMapping ("/ads/edit/{id}")
    public String adsPostEdit(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String full_text, Model model) {
        adsService.adsEdite(id, title, full_text);
        return "redirect:/ads";
    }
}

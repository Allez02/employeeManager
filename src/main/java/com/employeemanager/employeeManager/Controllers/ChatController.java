package com.employeemanager.employeeManager.Controllers;


import com.employeemanager.employeeManager.models.MessageModel;
import com.employeemanager.employeeManager.models.UsersModels;
import com.employeemanager.employeeManager.repo.MessageRepo;
import com.employeemanager.employeeManager.repo.UserRepo;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ChatController {
    private UserRepo user;

    private MessageRepo message;

    public ChatController(UserRepo user, MessageRepo message) {
        this.user = user;
        this.message = message;
    }



    @GetMapping("/chat")
    public String chat(Model model) {
        List<MessageModel> messageList = new ArrayList<>();
        message.findAll().forEach(messageList :: add);
        model.addAttribute("message", messageList);
        return "chat";
    }

    @PostMapping("/chat")
    public String postchat(Model model, Authentication auth, @RequestParam String text) {
        Date date = new Date();
        MessageModel message1 = new MessageModel(date, text, (UsersModels) auth.getPrincipal());
        message.save(message1);
        return "redirect:/chat";
    }

}

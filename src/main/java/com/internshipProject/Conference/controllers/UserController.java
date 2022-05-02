package com.internshipProject.Conference.controllers;

import com.internshipProject.Conference.models.User;
import com.internshipProject.Conference.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor

public class UserController {
    private  final UserService userService;
    @GetMapping("/login")
    public String login()
    {
        return "login";
    }

    @GetMapping("/registration")
    public String registration()
    {
        return "registration";
    }

    @PostMapping("/registration")
    public String createUser(User user, Model model){
        if(!userService.createUser(user)){
            model.addAttribute("errorMessage", "User with email:" + user.getEmail()+ "already exists");
            return "registration";
        }
        return "redirect:/login";
    }
}

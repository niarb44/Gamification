package com.example.gamification.controller;

import com.example.gamification.model.User2;
import com.example.gamification.repository.UserRepository;
import com.example.gamification.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private UserService service;


    @GetMapping
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User2());
        return "register";
    }

    @PostMapping
    public String registerUser(@ModelAttribute User2 user, Model model) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            model.addAttribute("error", "Username already exists!");
            return "register";
        }

        user.setPassword(user.getPassword());
        user.setPoints(0);
        service.saveUser(user);

        model.addAttribute("success", "User registered successfully!");
        return "redirect:/";
    }
}

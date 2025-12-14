
package com.example.gamification.controller;

import com.example.gamification.model.User2;
import com.example.gamification.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String home(Model model, Principal principal) {
        model.addAttribute("pageTitle", "Home");

        User2 user = userRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new RuntimeException("User not found"));

        model.addAttribute("user", user);

        return "home";
    }
}

package com.example.gamification.controller;

import com.example.gamification.model.User2;
import com.example.gamification.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ProfileController {

    private final UserService userService;

    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")
    public String userProfile(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        String username = userDetails.getUsername();
        User2 user = userService.getUserByUsername(username);

        model.addAttribute("user", user);

        model.addAttribute("username", user.getUsername());
        model.addAttribute("points", user.getPoints());
        model.addAttribute("level", user.getLevel());

        return "profile";
    }
}

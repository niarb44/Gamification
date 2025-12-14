
package com.example.gamification.controller;

import com.example.gamification.model.User2;
import com.example.gamification.repository.UserRepository;
import com.example.gamification.service.ThemeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/profile2")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ThemeService themeService;

    @GetMapping
    public String getProfile(Model model, Principal principal) {
        User2 user = userRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<String> levels = themeService.getLevelsForTheme(user.getTheme());
        model.addAttribute("user", user);
        model.addAttribute("levels", levels);

        return "profile2";
    }

    @PostMapping("/set-theme")
    public String setTheme(@RequestParam String theme, Principal principal, HttpSession session) {
        User2 user = userRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setTheme(theme);
        userRepository.save(user);

        session.setAttribute("selectedTheme", theme);

        return "redirect:/profile2";
    }

}

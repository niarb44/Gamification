
package com.example.gamification.controller;

import com.example.gamification.model.User2;
import com.example.gamification.repository.UserRepository;
import com.example.gamification.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class RankingController {

    private final UserService userService;

    @Autowired
    private UserRepository userRepository;


    public RankingController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/ranking")
    public String showRanking(Model model, Principal principal) {

        User2 user = userRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new RuntimeException("User not found"));

        model.addAttribute("user", user);

        List<User2> rankedUsers = userService.getRankedUsers();
        model.addAttribute("users", rankedUsers);
        return "ranking";
    }
}



package com.example.gamification.controller;

import com.example.gamification.model.Task;
import com.example.gamification.model.User2;
import com.example.gamification.repository.TaskRepository;
import com.example.gamification.service.TaskService;
import com.example.gamification.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/task")
    public String getTaskPage(Principal principal, Model model) {

        String username = principal.getName();
        User2 user = userService.getUserByUsername(username);

        Task task = taskService.getCurrentTaskForUser(user);

        model.addAttribute("task", task);
        model.addAttribute("user", user);
        return "task";
    }

    @PostMapping("/tasks/complete")
    public String markTaskAsCompleted(@RequestParam("taskId") int taskId) {

        System.out.println("Próba oznaczenia zadania o ID: {}" + taskId);
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new IllegalArgumentException("Zadanie o ID " + taskId + " nie zostało znalezione"));


        task.setCompleted(true);
        taskRepository.save(task);
        return "redirect:/task";
    }

}

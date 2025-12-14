
package com.example.gamification.service;

import com.example.gamification.model.Task;
import com.example.gamification.model.User2;
import com.example.gamification.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;


    public Task getCurrentTaskForUser(User2 user) {
        Long userId = Long.valueOf(user.getId());
        Optional<Task> taskOptional = taskRepository.findFirstIncompleteTaskNative(userId);

        return taskOptional.orElseGet(() -> {
            System.out.println("No task found for user ID: " + userId);
            return new Task("No Task Assigned", 0, false, user);
        });
    }


    public void completeCurrentTask(User2 user) {
        Long userId = Long.valueOf(user.getId());
        Task task = taskRepository.findFirstIncompleteTaskNative(userId)
                .orElse(null);

        if (task != null) {
            task.setCompleted(true);
            taskRepository.save(task);
        }
    }
}

// ///////////////////////////////////////////////
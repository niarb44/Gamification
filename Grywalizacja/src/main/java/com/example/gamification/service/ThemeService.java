package com.example.gamification.service;

import com.example.gamification.model.Level;
import com.example.gamification.repository.LevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ThemeService {

    @Autowired
    private LevelRepository levelRepository;

    public List<String> getLevelsForTheme(String theme) {
        List<Level> levels = levelRepository.findByTheme(theme);
        return levels.stream()
                .sorted(Comparator.comparingInt(Level::getLevelNumber))
                .map(Level::getName)
                .collect(Collectors.toList());
    }
}

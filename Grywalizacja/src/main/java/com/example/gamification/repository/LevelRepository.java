package com.example.gamification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.gamification.model.Level;

import java.util.List;

@Repository
public interface LevelRepository extends JpaRepository<Level, Long> {
    List<Level> findByTheme(String theme);
}

package com.example.gamification.repository;

import com.example.gamification.model.Points;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointsRepository extends JpaRepository<Points, Long> {
    List<Points> findByUsername(String username);
}

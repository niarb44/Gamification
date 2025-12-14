
package com.example.gamification.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gamification.model.User2;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User2, Integer> {

    User2 findByUsername(String username);

    List<User2> findAllByOrderByPointsDesc();
}

// ///////////////////////////////////////
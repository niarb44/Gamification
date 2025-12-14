
package com.example.gamification.repository;

import com.example.gamification.model.User2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User2, Long> {

    Optional<User2> findByUsername(String username);

    Optional<User2> findById(Long id);
}

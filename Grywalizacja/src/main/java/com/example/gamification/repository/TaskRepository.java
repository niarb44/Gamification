

package com.example.gamification.repository;

import com.example.gamification.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    @Query(value = "SELECT * FROM tasks WHERE user_id = :userId AND completed = false LIMIT 1", nativeQuery = true)
    Optional<Task> findFirstIncompleteTaskNative(@Param("userId") Long userId);

}


package com.example.gamification.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.gamification.model.User2;
import com.example.gamification.dao.UserRepo;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepo repo;
    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);

    public User2 saveUser(User2 user) {
        user.setPassword(encoder.encode(user.getPassword()));
        System.out.println(user.getPassword());
        return repo.save(user) ;

    }

    public User2 getUserByUsername(String username) {
        return repo.findByUsername(username);
    }

    public List<User2> getRankedUsers() {
        return repo.findAllByOrderByPointsDesc();
    }
}
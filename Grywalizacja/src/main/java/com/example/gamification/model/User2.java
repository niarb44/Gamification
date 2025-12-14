package com.example.gamification.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Table(name = "users")
@Entity
public class User2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String password;
    @Column(name = "points")
    private int points;
    private int level;

    @Column(nullable = false, columnDefinition = "default")
    private String theme;

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public int getLevel2() {
        return points / 100;
    }
}


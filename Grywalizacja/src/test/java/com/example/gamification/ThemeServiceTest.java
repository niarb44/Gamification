package com.example.gamification;

import com.example.gamification.service.ThemeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class ThemeServiceTest {

    @Autowired
    private ThemeService themeService;

    @Test
    public void testThemeLevels() {
        List<String> fantasyLevels = themeService.getLevelsForTheme("fantasy");
        assertNotNull(fantasyLevels);
        assertTrue(fantasyLevels.contains("Knight"));

        List<String> sciFiLevels = themeService.getLevelsForTheme("sci-fi");
        assertNotNull(sciFiLevels);
        assertTrue(sciFiLevels.contains("Space Explorer"));
    }
}

package com.example.gamification;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class LoginTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSuccessfulLogin() throws Exception {
        mockMvc.perform(formLogin("/login").user("Pau").password("Pau"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/")); // Oczekiwane przekierowanie
    }

    @Test
    public void testFailedLogin() throws Exception {
        mockMvc.perform(formLogin("/login").user("wronguser").password("wrongpassword"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/login?error"));
    }
}

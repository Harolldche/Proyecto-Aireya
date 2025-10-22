package com.aireya.aireya.web.controller;

import com.aireya.aireya.config.TestSecurityConfig;
import com.aireya.aireya.domain.model.User;
import com.aireya.aireya.security.JwtUtil;
import com.aireya.aireya.service.UserService;
import com.aireya.aireya.web.dto.LoginRequestDto;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AuthController.class)
@Import(TestSecurityConfig.class) // desactiva filtros de seguridad durante el test
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthenticationManager authenticationManager;

    @MockBean
    private JwtUtil jwtUtil;

    @MockBean
    private UserService userService;

    @Test
    void login_returnsToken_whenCredentialsAreValid() throws Exception {
        LoginRequestDto dto = new LoginRequestDto();
        dto.setUsername("testuser");
        dto.setPassword("password");

        User user = new User();
        user.setUsername("testuser");
        user.setRole("USER");

        Authentication auth = new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword());

        Mockito.when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
                .thenReturn(auth);
        Mockito.when(userService.findByUsername(eq("testuser"))).thenReturn(user);
        Mockito.when(jwtUtil.generateToken(eq("testuser"), eq("USER"))).thenReturn("fake-jwt-token");

        mockMvc.perform(post("/api/v1/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\": \"testuser\", \"password\": \"password\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").value("fake-jwt-token"))
                .andExpect(jsonPath("$.expiresInMs").exists());
    }

    @Test
    void login_returnsUnauthorized_whenPasswordInvalid() throws Exception {
        Mockito.when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
                .thenThrow(new org.springframework.security.core.AuthenticationException("Bad credentials") {});

        mockMvc.perform(post("/api/v1/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\": \"testuser\", \"password\": \"wrong\"}"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void login_returnsUnauthorized_whenUserNotFound() throws Exception {
    // Simula fallo en la autenticación (usuario no válido)
    Mockito.when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
            .thenThrow(new org.springframework.security.core.AuthenticationException("User not found") {});

    mockMvc.perform(post("/api/v1/auth/login")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{\"username\": \"unknown\", \"password\": \"password\"}"))
            .andExpect(status().isUnauthorized());
    }

}

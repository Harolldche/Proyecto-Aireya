package com.aireya.aireya.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
class SecurityConfigIntegrationTest {

    @Autowired
    private SecurityFilterChain filterChain;

    @Test
    void filterChainLoads() {
        // Este test inicializa el contexto completo y ejecuta los lambdas internos de SecurityConfig
        assertNotNull(filterChain);
    }
}

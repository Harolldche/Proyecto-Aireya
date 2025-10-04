package com.aireya.aireya.config;

import com.aireya.aireya.domain.model.User;
import com.aireya.aireya.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class DataInitializer {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Bean
    public CommandLineRunner init() {
        return args -> {
            if (!userRepository.existsByUsername("admin")) {
                User u = new User();
                u.setUsername("admin");
                u.setPassword(passwordEncoder.encode("admin123"));
                u.setRole("ADMIN");
                userRepository.save(u);
                System.out.println("Usuario admin creado: username=admin, password=admin123 (cambiar en producción)");
            }
        };
    }
}

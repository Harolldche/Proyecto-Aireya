package com.aireya.aireya.service.impl;

import com.aireya.aireya.domain.model.User;
import com.aireya.aireya.repository.UserRepository;
import com.aireya.aireya.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User findByUsername(String username) {
        return repository.findByUsername(username).orElse(null);
    }

    @Override
    public User createUser(User user) {
        if (repository.existsByUsername(user.getUsername())) {
            throw new IllegalArgumentException("Usuario ya existe: " + user.getUsername());
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }
}

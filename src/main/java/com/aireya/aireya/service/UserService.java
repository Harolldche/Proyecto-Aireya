package com.aireya.aireya.service;

import com.aireya.aireya.domain.model.User;

public interface UserService {
    User findByUsername(String username);
    User createUser(User user);
}

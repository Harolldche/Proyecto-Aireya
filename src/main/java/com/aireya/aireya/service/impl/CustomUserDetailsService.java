package com.aireya.aireya.service.impl;

import com.aireya.aireya.domain.model.User;
import com.aireya.aireya.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                mapRoleToAuthorities(user.getRole())
        );
    }

    private Collection<? extends GrantedAuthority> mapRoleToAuthorities(String role) {
        return List.of(new SimpleGrantedAuthority("ROLE_" + role));
    }
}

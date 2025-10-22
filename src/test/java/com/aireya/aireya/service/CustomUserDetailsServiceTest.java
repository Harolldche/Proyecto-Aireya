
package com.aireya.aireya.service;

import com.aireya.aireya.domain.model.User;
import com.aireya.aireya.repository.UserRepository;
import com.aireya.aireya.service.impl.CustomUserDetailsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomUserDetailsServiceTest {

    @Mock
    UserRepository repository;

    @InjectMocks
    CustomUserDetailsService service;

    @Test
    void loadUserByUsernameSuccess() {
        User u = new User();
        u.setUsername("pepito");
        u.setPassword("secret");
        u.setRole("USER");

        when(repository.findByUsername("pepito")).thenReturn(Optional.of(u));

        UserDetails ud = service.loadUserByUsername("pepito");
        assertNotNull(ud);
        assertEquals("pepito", ud.getUsername());
    }

    @Test
    void loadUserByUsernameNotFound() {
        when(repository.findByUsername("no")).thenReturn(Optional.empty());
        assertThrows(UsernameNotFoundException.class, () -> service.loadUserByUsername("no"));
    }
}

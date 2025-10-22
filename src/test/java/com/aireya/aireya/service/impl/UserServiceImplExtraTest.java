
package com.aireya.aireya.service.impl;

import com.aireya.aireya.domain.model.User;
import com.aireya.aireya.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplExtraTest {

    @Mock UserRepository repository;
    @Mock PasswordEncoder passwordEncoder;
    @InjectMocks UserServiceImpl service;

    @Test
    void findByUsernameReturnsNullWhenAbsent() {
        when(repository.findByUsername("no")).thenReturn(Optional.empty());
        assertNull(service.findByUsername("no"));
    }

    @Test
    void createUserEncodesPassword() {
        User u = new User();
        u.setUsername("abc"); u.setPassword("p");
        when(repository.existsByUsername("abc")).thenReturn(false);
        when(passwordEncoder.encode("p")).thenReturn("enc");
        when(repository.save(any())).thenAnswer(inv -> { User uu=inv.getArgument(0); uu.setId(55L); return uu;});
        User res = service.createUser(u);
        assertEquals(55L, res.getId());
        verify(passwordEncoder).encode("p");
    }
}

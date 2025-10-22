
package com.aireya.aireya.service;

import com.aireya.aireya.domain.model.User;
import com.aireya.aireya.repository.UserRepository;
import com.aireya.aireya.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    UserRepository repository;

    @Mock
    PasswordEncoder passwordEncoder;

    @InjectMocks
    UserServiceImpl service;

    @Test
    void createUserSuccess() {
        User u = new User();
        u.setUsername("nuevo");
        u.setPassword("plain");

        when(repository.existsByUsername("nuevo")).thenReturn(false);
        when(passwordEncoder.encode("plain")).thenReturn("encoded");
        when(repository.save(any())).thenAnswer(inv -> {
            User uu = inv.getArgument(0);
            uu.setId(1L);
            return uu;
        });

        User res = service.createUser(u);
        assertNotNull(res);
        assertEquals(1L, res.getId());
        verify(repository).save(any());
    }

    @Test
    void createUserAlreadyExists() {
        User u = new User();
        u.setUsername("existe");
        u.setPassword("p");

        when(repository.existsByUsername("existe")).thenReturn(true);
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> service.createUser(u));
        assertTrue(ex.getMessage().contains("Usuario ya existe"));
        verify(repository, never()).save(any());
    }
}

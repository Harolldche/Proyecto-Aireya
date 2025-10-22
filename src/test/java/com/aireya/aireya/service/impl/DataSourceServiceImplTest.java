package com.aireya.aireya.service.impl;

import com.aireya.aireya.domain.model.DataSource;
import com.aireya.aireya.repository.DataSourceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DataSourceServiceImplTest {

    @Mock
    DataSourceRepository repo;

    @InjectMocks
    DataSourceServiceImpl service;

    @Test
    void listAll_callsRepository() {
        // Configurar mocks
        when(repo.findAll()).thenReturn(List.of(new DataSource()));

        // Ejecutar
        var res = service.listAll();

        // Verificar
        assertNotNull(res);
        assertEquals(1, res.size());
        verify(repo, times(1)).findAll();
    }
}

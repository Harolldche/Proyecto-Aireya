
package com.aireya.aireya.service.impl;

import com.aireya.aireya.domain.model.DataSource;
import com.aireya.aireya.repository.DataSourceRepository;
import com.aireya.aireya.web.dto.DataSourceDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DataSourceServiceImplExtraTest {

    @Mock DataSourceRepository repo;
    @InjectMocks DataSourceServiceImpl service;

    @Test
    void listAllReturnsDtos() {
        DataSource s = new DataSource(); s.setId(2L); s.setCode("IQAIR");
        when(repo.findAll()).thenReturn(List.of(s));
        var res = service.listAll();
        assertEquals(1, res.size());
        assertEquals("IQAIR", res.get(0).code());
    }
}

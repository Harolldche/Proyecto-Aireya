package com.aireya.aireya.service;

import com.aireya.aireya.domain.model.Department;
import com.aireya.aireya.repository.DepartmentRepository;
import com.aireya.aireya.service.impl.DepartmentServiceImpl;
import com.aireya.aireya.web.dto.DepartmentDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class DepartmentServiceImplTest {

    @Mock DepartmentRepository repo;
    @InjectMocks DepartmentServiceImpl service;

    @Test
    void listAll_returnsMappedDtos() {
        Department d = new Department();
        d.setId(1L);
        d.setName("San Test");

        when(repo.findAll()).thenReturn(List.of(d));

        var out = service.listAll();
        assertEquals(1, out.size());
        DepartmentDto dto = out.get(0);
        assertEquals(1L, dto.id());
        assertEquals("San Test", dto.name());
    }
}

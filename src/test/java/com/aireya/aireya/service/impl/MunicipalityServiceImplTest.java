package com.aireya.aireya.service.impl;

import com.aireya.aireya.domain.model.Department;
import com.aireya.aireya.domain.model.Municipality;
import com.aireya.aireya.repository.MunicipalityRepository;
import com.aireya.aireya.web.dto.MunicipalityDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MunicipalityServiceImplTest {

    @Mock MunicipalityRepository municipalityRepo;
    @InjectMocks MunicipalityServiceImpl service;

    @Test
    void list_whenDepartmentIdIsNull_callsFindAll() {
        Department d = new Department();
        d.setId(1L);
        d.setName("Dept1");

        Municipality m = new Municipality();
        m.setId(1L);
        m.setName("Test");
        m.setDepartment(d);

        when(municipalityRepo.findAll(any(Pageable.class)))
                .thenReturn(new PageImpl<>(List.of(m)));

        Page<MunicipalityDto> result = service.list(null, PageRequest.of(0, 10));

        assertEquals(1, result.getTotalElements());
        verify(municipalityRepo, times(1)).findAll(any(Pageable.class));
    }

    @Test
    void list_whenDepartmentIdIsProvided_callsFindByDepartmentId() {
        Department d = new Department();
        d.setId(5L);
        d.setName("Dept2");

        Municipality m = new Municipality();
        m.setId(2L);
        m.setName("DepTest");
        m.setDepartment(d);

        when(municipalityRepo.findByDepartmentId(eq(5L), any(Pageable.class)))
                .thenReturn(new PageImpl<>(List.of(m)));

        Page<MunicipalityDto> result = service.list(5L, PageRequest.of(0, 10));

        assertEquals(1, result.getTotalElements());
        verify(municipalityRepo, times(1)).findByDepartmentId(eq(5L), any(Pageable.class));
    }
}

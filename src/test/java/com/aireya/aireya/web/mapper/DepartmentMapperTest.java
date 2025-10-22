package com.aireya.aireya.web.mapper;

import com.aireya.aireya.domain.model.Department;
import com.aireya.aireya.web.dto.DepartmentDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentMapperTest {

    @Test
    void testToDto() {
        Department d = new Department();
        d.setId(10L);
        d.setName("La Libertad");

        DepartmentDto dto = DepartmentMapper.toDto(d);

        assertNotNull(dto);
        assertEquals(10L, dto.id());
        assertEquals("La Libertad", dto.name());
    }

    @Test
    void testConstructor() {
        // Simplemente crear una instancia para cubrir el constructor por defecto
        new DepartmentMapper();
    }
}

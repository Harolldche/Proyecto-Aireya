
package com.aireya.aireya.web.mapper;

import com.aireya.aireya.domain.model.DataSource;
import com.aireya.aireya.web.dto.DataSourceDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataSourceMapperTest {

    @Test
    void testToDto() {
        DataSource s = new DataSource();
        s.setId(123L);
        s.setCode("IQAIR");
        s.setDescription("Fuente de prueba");
        s.setContactUrl("https://example.com/contact");

        DataSourceDto dto = DataSourceMapper.toDto(s);
        assertNotNull(dto);
        assertEquals(123L, dto.id());
        assertEquals("IQAIR", dto.code());
        assertEquals("Fuente de prueba", dto.description());
        assertEquals("https://example.com/contact", dto.contactUrl());
    }
    
    @Test
    void testConstructor() {
        // Simplemente crear una instancia para cubrir el constructor por defecto
        new DataSourceMapper();
    }
}

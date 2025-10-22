package com.aireya.aireya.web.mapper;

import com.aireya.aireya.domain.model.DataSource;
import com.aireya.aireya.domain.model.Municipality;
import com.aireya.aireya.domain.model.Station;
import com.aireya.aireya.web.dto.StationDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StationMapperTest {

    @Test
    void testToDto() {
        // Crear objetos relacionados
        Municipality municipality = new Municipality();
        municipality.setId(5L);

        DataSource dataSource = new DataSource();
        dataSource.setId(9L);

        // Crear la entidad Station
        Station station = new Station();
        station.setId(1L);
        station.setName("Estación Central");
        station.setMunicipality(municipality);
        station.setDataSource(dataSource);
        station.setLatitude(13.6929);
        station.setLongitude(-89.2182);
        station.setActive(true);

        // Ejecutar mapper
        StationDto dto = StationMapper.toDto(station);

        // Validar resultados
        assertNotNull(dto);
        assertEquals(1L, dto.id());
        assertEquals("Estación Central", dto.name());
        assertEquals(5L, dto.municipalityId());
        assertEquals(9L, dto.dataSourceId());
        assertEquals(13.6929, dto.latitude());
        assertEquals(-89.2182, dto.longitude());
        assertTrue(dto.active());
    }

    @Test
    void testPrivateConstructorForCoverage() throws Exception {
        var constructor = StationMapper.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        constructor.newInstance(); // Ejecuta el constructor implícito
    }
}

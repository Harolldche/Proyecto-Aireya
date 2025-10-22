package com.aireya.aireya.web.mapper;

import com.aireya.aireya.domain.common.Pollutant;
import com.aireya.aireya.domain.model.DataSource;
import com.aireya.aireya.domain.model.Measurement;
import com.aireya.aireya.domain.model.Station;
import com.aireya.aireya.web.dto.MeasurementDto;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de prueba unitaria para la clase MeasurementMapper.
 * 
 * Su objetivo es verificar que el mapeo entre la entidad Measurement (modelo de dominio)
 * y el DTO MeasurementDto (objeto de transferencia de datos) se realice correctamente.
 */
class MeasurementMapperTest {

    /**
     * Prueba principal que verifica el método estático toDto().
     * 
     * Se asegura que todos los campos de un objeto Measurement
     * sean correctamente transferidos a su respectivo MeasurementDto.
     */
    @Test
    void testToDto() {
        // Creamos una instancia de Station (estación de medición)
        Station station = new Station();
        station.setId(10L); // Asignamos un ID para verificar en el DTO

        // Creamos una instancia de DataSource (fuente de datos)
        DataSource dataSource = new DataSource();
        dataSource.setId(20L);

        // Creamos una medición con datos completos
        Measurement measurement = new Measurement();
        measurement.setId(1L);
        measurement.setPollutant(Pollutant.CO2); // Tipo de contaminante
        measurement.setValue(35.7);               // Valor medido
        measurement.setUnit("µg/m³");             // Unidad de medida
        measurement.setTimestampUtc(Instant.parse("2025-10-17T23:00:00Z")); // Fecha/hora UTC
        measurement.setStation(station);          // Estación asociada
        measurement.setDataSource(dataSource);    // Fuente de datos asociada

        // Convertimos la entidad Measurement a su DTO correspondiente
        MeasurementDto dto = MeasurementMapper.toDto(measurement);

        // Verificamos que el resultado no sea nulo
        assertNotNull(dto);

        // Comprobamos que todos los campos se hayan mapeado correctamente
        assertEquals(1L, dto.id());
        assertEquals(Pollutant.CO2, dto.pollutant());
        assertEquals(35.7, dto.value());
        assertEquals("µg/m³", dto.unit());
        assertEquals(Instant.parse("2025-10-17T23:00:00Z"), dto.timestampUtc());
        assertEquals(10L, dto.stationId());
        assertEquals(20L, dto.dataSourceId());
    }

    /**
     * Prueba adicional para cubrir el constructor privado de la clase MeasurementMapper.
     * 
     * Este tipo de prueba se utiliza cuando la clase contiene solo métodos estáticos
     * y su constructor es privado para evitar instanciación.
     * 
     * Se usa reflexión para acceder e invocar el constructor,
     * asegurando así cobertura total en los reportes de pruebas.
     */
    @Test
    void testPrivateConstructorForCoverage() throws Exception {
        // Obtenemos el constructor privado de MeasurementMapper
        var constructor = MeasurementMapper.class.getDeclaredConstructor();
        
        // Permitimos acceso al constructor privado
        constructor.setAccessible(true);
        
        // Creamos una instancia de la clase (aunque no se use)
        constructor.newInstance();
    }
}

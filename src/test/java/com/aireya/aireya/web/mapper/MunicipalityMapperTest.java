package com.aireya.aireya.web.mapper;

import com.aireya.aireya.domain.model.Department;
import com.aireya.aireya.domain.model.Municipality;
import com.aireya.aireya.web.dto.MunicipalityDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase MunicipalityMapper.
 * 
 * Se verifica que el mapeo de la entidad Municipality hacia el DTO
 * MunicipalityDto se realice correctamente.
 */
class MunicipalityMapperTest {

    /**
     * Prueba principal que verifica el método estático toDto().
     * 
     * Se asegura que todos los campos relevantes de una entidad Municipality
     * se transfieran correctamente a su DTO correspondiente.
     */
    @Test
    void testToDto() {
        // Creamos un Department simulado
        Department d = new Department();
        d.setId(55L);            // ID del departamento
        d.setName("San Salvador"); // Nombre del departamento

        // Creamos un Municipio vinculado al departamento
        Municipality m = new Municipality();
        m.setId(7L);             // ID del municipio
        m.setName("Soyapango");  // Nombre del municipio
        m.setDepartment(d);      // Asociación con el departamento

        // Convertimos la entidad Municipality a su DTO
        MunicipalityDto dto = MunicipalityMapper.toDto(m);

        // Validamos que el DTO no sea nulo
        assertNotNull(dto);

        // Verificamos que todos los campos se hayan mapeado correctamente
        assertEquals(7L, dto.id());
        assertEquals("Soyapango", dto.name());
        assertEquals(55L, dto.departmentId());
    }

    /**
     * Prueba para cubrir el constructor de la clase MunicipalityMapper.
     * 
     * Aunque la clase tiene solo métodos estáticos, invocamos el constructor
     * para asegurar cobertura completa en los reportes de pruebas.
     */
    @Test
    void testConstructor() {
        new MunicipalityMapper(); // Se crea la instancia solo para cobertura
    }
}

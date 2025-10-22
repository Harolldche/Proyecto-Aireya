package com.aireya.aireya.web.controller;

import com.aireya.aireya.config.TestSecurityConfig;
import com.aireya.aireya.domain.common.Pollutant;
import com.aireya.aireya.service.MeasurementService;
import com.aireya.aireya.web.dto.MeasurementCreateDto;
import com.aireya.aireya.web.dto.MeasurementDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.*;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test de controlador de mediciones.
 * Importa TestSecurityConfig para permitir llamadas sin seguridad real.
 */
@WebMvcTest(controllers = MeasurementController.class)
@Import(TestSecurityConfig.class)
class MeasurementControllerTest {

    @Autowired MockMvc mockMvc;
    @Autowired ObjectMapper objectMapper;

    @MockBean MeasurementService service;

    @Test
    void getMeasurements_returnsOk() throws Exception {
        Page<MeasurementDto> page = new PageImpl<>(List.of(
                new MeasurementDto(1L, Pollutant.PM10, 45.5, "µg/m³", Instant.now(), 1L, 2L)
        ));
        when(service.getAllMeasurements(any(Pageable.class))).thenReturn(page);

        mockMvc.perform(get("/api/v1/measurements?page=0&size=10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].pollutant").value("PM10"));
    }

    @Test
    void createMeasurement_returnsCreated() throws Exception {
        MeasurementCreateDto dto = new MeasurementCreateDto(Pollutant.PM10, 45.5, "µg/m³",
                Instant.now(), 1L, 2L);
        MeasurementDto response = new MeasurementDto(1L, Pollutant.PM10, 45.5, "µg/m³",
                Instant.now(), 1L, 2L);

        when(service.createMeasurement(any(MeasurementCreateDto.class))).thenReturn(response);

        mockMvc.perform(post("/api/v1/measurements")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.pollutant").value("PM10"));
    }

    @Test
    void updateMeasurement_returnsOk() throws Exception {
        MeasurementCreateDto dto = new MeasurementCreateDto(Pollutant.CO2, 12.3, "ppm",
                Instant.now(), 2L, 3L);
        MeasurementDto response = new MeasurementDto(5L, Pollutant.CO2, 12.3, "ppm",
                Instant.now(), 2L, 3L);

        when(service.updateMeasurement(Mockito.eq(5L), any(MeasurementCreateDto.class)))
                .thenReturn(response);

        mockMvc.perform(put("/api/v1/measurements/5")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pollutant").value("CO2"));
    }

    @Test
    void deleteMeasurement_returnsNoContent() throws Exception {
        mockMvc.perform(delete("/api/v1/measurements/5"))
                .andExpect(status().isNoContent());
        Mockito.verify(service).deleteMeasurement(5L);
    }

    @Test
    void search_returnsOk() throws Exception {
        when(service.search(any(), any(), any(), any(), any(), any())).thenReturn(Page.empty());
        mockMvc.perform(get("/api/v1/measurements"))
                .andExpect(status().isOk());
    }
}

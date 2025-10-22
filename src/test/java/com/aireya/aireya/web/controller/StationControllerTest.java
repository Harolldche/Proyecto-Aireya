package com.aireya.aireya.web.controller;

import com.aireya.aireya.config.TestSecurityConfig;
import com.aireya.aireya.service.StationService;
import com.aireya.aireya.web.dto.StationCreateDto;
import com.aireya.aireya.web.dto.StationDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StationController.class)
@Import(TestSecurityConfig.class)
class StationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StationService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void list_ok() throws Exception {
        Page<StationDto> page = new PageImpl<>(List.of(
                new StationDto(1L, "Estación Central", 1L, 1L, 13.7, -89.2, true)
        ));
        Mockito.when(service.list(any(), any(Pageable.class))).thenReturn(page);

        mockMvc.perform(get("/api/v1/stations")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].name").value("Estación Central"));
    }

    @Test
    void create_ok() throws Exception {
        StationCreateDto input = new StationCreateDto(
                "Nueva Estación", 1L, 1L, 14.0, -90.0, true
        );
        StationDto result = new StationDto(10L, "Nueva Estación", 1L, 1L, 14.0, -90.0, true);

        Mockito.when(service.create(any())).thenReturn(result);

        mockMvc.perform(post("/api/v1/stations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(10L))
                .andExpect(jsonPath("$.name").value("Nueva Estación"));
    }

    @Test
    void get_ok() throws Exception {
        StationDto dto = new StationDto(5L, "Estación Norte", 2L, 1L, 12.5, -88.0, true);
        Mockito.when(service.get(5L)).thenReturn(dto);

        mockMvc.perform(get("/api/v1/stations/5")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Estación Norte"));
    }

    @Test
    void update_ok() throws Exception {
        StationCreateDto updateDto = new StationCreateDto(
                "Estación Modificada", 3L, 2L, 13.0, -89.5, false
        );
        StationDto updated = new StationDto(7L, "Estación Modificada", 3L, 2L, 13.0, -89.5, false);

        Mockito.when(service.update(eq(7L), any())).thenReturn(updated);

        mockMvc.perform(put("/api/v1/stations/7")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updateDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Estación Modificada"))
                .andExpect(jsonPath("$.active").value(false));
    }

    @Test
    void delete_ok() throws Exception {
        mockMvc.perform(delete("/api/v1/stations/99"))
                .andExpect(status().isNoContent());

        Mockito.verify(service).delete(99L);
    }
}

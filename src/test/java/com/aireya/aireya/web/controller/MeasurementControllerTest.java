package com.aireya.aireya.web.controller;

import com.aireya.aireya.service.MeasurementService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Prueba del controlador usando MockMvc (no toca base de datos).
 */
@WebMvcTest(controllers = MeasurementController.class)
class MeasurementControllerTest {

    @Autowired MockMvc mockMvc;
    @MockBean MeasurementService service;

    @Test
    void search_returnsOk() throws Exception {
        when(service.search(any(), any(), any(), any(), any(), any())).thenReturn(Page.empty());
        mockMvc.perform(get("/api/v1/measurements"))
                .andExpect(status().isOk());
    }
}

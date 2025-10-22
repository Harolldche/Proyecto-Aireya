package com.aireya.aireya.web.controller;

import com.aireya.aireya.config.TestSecurityConfig;
import com.aireya.aireya.service.DataSourceService;
import com.aireya.aireya.web.dto.DataSourceDto;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DataSourceController.class)
@Import(TestSecurityConfig.class) // Desactiva seguridad durante las pruebas
class DataSourceControllerTest {

    @Autowired 
    MockMvc mockMvc;

    @MockBean 
    DataSourceService service;

    @Test
    void listAll_ok() throws Exception {
        Mockito.when(service.listAll()).thenReturn(List.of(
                new DataSourceDto(1L, "DS1", "Desc", "http://a.com")
        ));

        mockMvc.perform(get("/api/v1/datasources")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].code").value("DS1"));
    }
}

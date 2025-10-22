package com.aireya.aireya.web.controller;

import com.aireya.aireya.config.TestSecurityConfig;
import com.aireya.aireya.service.DepartmentService;
import com.aireya.aireya.web.dto.DepartmentDto;
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

@WebMvcTest(DepartmentController.class)
@Import(TestSecurityConfig.class)
class DepartmentControllerTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    DepartmentService service;

    @Test
    void listAll_ok() throws Exception {
        Mockito.when(service.listAll()).thenReturn(List.of(
                new DepartmentDto(1L, "San Salvador")
        ));

        mockMvc.perform(get("/api/v1/departments")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("San Salvador"));
    }
}

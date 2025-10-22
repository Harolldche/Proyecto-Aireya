package com.aireya.aireya.web.controller;

import com.aireya.aireya.config.TestSecurityConfig;
import com.aireya.aireya.service.MunicipalityService;
import com.aireya.aireya.web.dto.MunicipalityDto;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MunicipalityController.class)
@Import(TestSecurityConfig.class)
class MunicipalityControllerTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    MunicipalityService service;

    @Test
    void list_ok() throws Exception {
        Page<MunicipalityDto> page = new PageImpl<>(List.of(
                new MunicipalityDto(1L, "Soyapango", 1L)
        ));
        Mockito.when(service.list(Mockito.any(), Mockito.any(Pageable.class)))
                .thenReturn(page);

        mockMvc.perform(get("/api/v1/municipalities")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].name").value("Soyapango"));
    }
}

package com.aireya.aireya.web.controller;


import com.aireya.aireya.service.DataSourceService;
import com.aireya.aireya.web.dto.DataSourceDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/**
 * Catálogo: Fuentes de datos.
 */
@RestController
@RequestMapping("/api/v1/datasources")
@RequiredArgsConstructor
public class DataSourceController {


    private final DataSourceService service;


    @GetMapping
    @Operation(summary = "Lista fuentes de datos registradas")
    public List<DataSourceDto> list() {
        return service.listAll();
    }
}

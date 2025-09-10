package com.aireya.aireya.web.controller;

import com.aireya.aireya.service.DepartmentService;
import com.aireya.aireya.web.dto.DepartmentDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Catálogo: Departamentos.
 */
@RestController
@RequestMapping("/api/v1/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService service;

    @GetMapping
    @Operation(summary = "Lista todos los departamentos")
    public List<DepartmentDto> list() {
        return service.listAll();
    }
}

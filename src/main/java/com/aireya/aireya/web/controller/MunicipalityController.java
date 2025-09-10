package com.aireya.aireya.web.controller;

import com.aireya.aireya.service.MunicipalityService;
import com.aireya.aireya.web.dto.MunicipalityDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

/**
 * Catálogo: Municipios.
 */
@RestController
@RequestMapping("/api/v1/municipalities")
@RequiredArgsConstructor
public class MunicipalityController {

    private final MunicipalityService service;

    @GetMapping
    @Operation(summary = "Lista municipios; puede filtrar por departmentId")
    public Page<MunicipalityDto> list(@RequestParam(required = false) Long departmentId,
                                      Pageable pageable) {
        return service.list(departmentId, pageable);
    }
}

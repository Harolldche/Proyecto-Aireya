package com.aireya.aireya.web.controller;

import com.aireya.aireya.domain.common.Pollutant;
import com.aireya.aireya.service.MeasurementService;
import com.aireya.aireya.web.dto.MeasurementCreateDto;
import com.aireya.aireya.web.dto.MeasurementDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

/**
 * Endpoints de mediciones.
 */
@RestController
@RequestMapping("/api/v1/measurements")
@RequiredArgsConstructor
public class MeasurementController {

    private final MeasurementService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crea una medición")
    public MeasurementDto create(@Valid @RequestBody MeasurementCreateDto dto) {
        return service.create(dto);
    }

    @GetMapping
    @Operation(summary = "Busca mediciones con filtros y paginación")
    public Page<MeasurementDto> search(@RequestParam(required = false) Long municipalityId,
                                       @RequestParam(required = false) Long stationId,
                                       @RequestParam(required = false) Pollutant pollutant,
                                       @RequestParam(required = false) Instant from,
                                       @RequestParam(required = false) Instant to,
                                       Pageable pageable) {
        return service.search(municipalityId, stationId, pollutant, from, to, pageable);
    }
}

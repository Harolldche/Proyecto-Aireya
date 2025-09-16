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
@RequestMapping("/api/measurements")
@RequiredArgsConstructor
public class MeasurementController {


    private final MeasurementService measurementService;


    @GetMapping
    @Operation(summary = "Obtener todas las mediciones (paginadas)")
    public Page<MeasurementDto> getMeasurements(Pageable pageable) {
        return measurementService.getAllMeasurements(pageable);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear una nueva medición")
    public MeasurementDto createMeasurement(@Valid @RequestBody MeasurementCreateDto dto) {
        return measurementService.createMeasurement(dto);
    }


    /**
     * Actualizar una medición existente.
     */
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una medición por ID")
    public MeasurementDto updateMeasurement(@PathVariable Long id, @Valid @RequestBody MeasurementCreateDto dto) {
        return measurementService.updateMeasurement(id, dto);
    }


    /**
     * Eliminar una medición por ID.
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una medición por ID")
    public void deleteMeasurement(@PathVariable Long id) {
        measurementService.deleteMeasurement(id);
    }
}



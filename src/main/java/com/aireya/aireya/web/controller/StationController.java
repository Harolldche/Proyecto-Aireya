package com.aireya.aireya.web.controller;

import com.aireya.aireya.service.StationService;
import com.aireya.aireya.web.dto.StationCreateDto;
import com.aireya.aireya.web.dto.StationDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

/**
 * CRUD de estaciones. En fase 3 se restringirá con JWT.
 */
@RestController
@RequestMapping("/api/v1/stations")
@RequiredArgsConstructor
public class StationController {

    private final StationService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crea una estación")
    public StationDto create(@Valid @RequestBody StationCreateDto dto) {
        return service.create(dto);
    }

    @GetMapping
    @Operation(summary = "Lista estaciones; filtra por municipalityId si se indica")
    public Page<StationDto> list(@RequestParam(required = false) Long municipalityId,
                                 Pageable pageable) {
        return service.list(municipalityId, pageable);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtiene una estación por id")
    public StationDto get(@PathVariable Long id) {
        return service.get(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualiza una estación")
    public StationDto update(@PathVariable Long id, @Valid @RequestBody StationCreateDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Elimina una estación")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

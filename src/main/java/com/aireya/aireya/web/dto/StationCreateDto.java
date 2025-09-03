package com.aireya.aireya.web.dto;

import jakarta.validation.constraints.*;

/**
 * Datos de entrada para crear/actualizar estaciones.
 */
public record StationCreateDto(
        @NotBlank @Size(max = 120) String name,
        @NotNull Long municipalityId,
        @NotNull Long dataSourceId,
        @DecimalMin(value = "-90.0") @DecimalMax("90.0") Double latitude,
        @DecimalMin(value = "-180.0") @DecimalMax("180.0") Double longitude,
        Boolean active
) { }

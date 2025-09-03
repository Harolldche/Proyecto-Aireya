package com.aireya.aireya.web.dto;

import com.aireya.aireya.domain.common.Pollutant;
import com.aireya.aireya.web.validation.ValidMeasurementUnit;
import jakarta.validation.constraints.*;
import java.time.Instant;

/**
 * Entrada para crear/actualizar mediciones. 
 * Lleva validador de unidad/contaminante.
 */
@ValidMeasurementUnit
public record MeasurementCreateDto(
        @NotNull Pollutant pollutant,

        @NotNull @Positive Double value,

        @NotBlank String unit,

        @NotNull Instant timestampUtc,

        @NotNull Long stationId,

        @NotNull Long dataSourceId
) { }

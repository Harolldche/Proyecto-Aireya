package com.aireya.aireya.web.dto;

import com.aireya.aireya.domain.common.Pollutant;
import java.time.Instant;

/** Salida de medición. */
public record MeasurementDto(
        Long id, Pollutant pollutant, Double value, String unit,
        Instant timestampUtc, Long stationId, Long dataSourceId
) { }

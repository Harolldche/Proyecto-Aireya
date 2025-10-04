package com.aireya.aireya.web.dto;

/** Vista de salida de estación. */
public record StationDto(
        Long id, String name, Long municipalityId, Long dataSourceId,
        Double latitude, Double longitude, Boolean active
) { }

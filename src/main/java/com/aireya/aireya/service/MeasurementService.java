package com.aireya.aireya.service;

import com.aireya.aireya.domain.common.Pollutant;
import com.aireya.aireya.web.dto.MeasurementCreateDto;
import com.aireya.aireya.web.dto.MeasurementDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.Instant;

public interface MeasurementService {


    MeasurementDto create(MeasurementCreateDto dto);
    Page<MeasurementDto> search(Long municipalityId, Long stationId, Pollutant pollutant,
                                Instant from, Instant to, Pageable pageable);

    // obtener todas las mediciones con paginación
    Page<MeasurementDto> getAllMeasurements(Pageable pageable);

    // crear (similar al create original, pero más expresivo para el controller)
    MeasurementDto createMeasurement(MeasurementCreateDto dto);

    // actualizar todos los campos de una medición
    MeasurementDto updateMeasurement(Long id, MeasurementCreateDto dto);

    // eliminar una medición por ID
    void deleteMeasurement(Long id);
}

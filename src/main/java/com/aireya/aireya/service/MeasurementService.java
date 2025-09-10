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
}

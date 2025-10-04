package com.aireya.aireya.service;

import com.aireya.aireya.web.dto.StationCreateDto;
import com.aireya.aireya.web.dto.StationDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StationService {
    StationDto create(StationCreateDto dto);
    Page<StationDto> list(Long municipalityId, Pageable pageable);
    StationDto get(Long id);
    StationDto update(Long id, StationCreateDto dto);
    void delete(Long id);
}


package com.aireya.aireya.service.impl;

import com.aireya.aireya.domain.model.*;
import com.aireya.aireya.exception.NotFoundException;
import com.aireya.aireya.repository.*;
import com.aireya.aireya.web.dto.StationCreateDto;
import com.aireya.aireya.web.dto.StationDto;
import com.aireya.aireya.web.mapper.StationMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StationServiceImplExtraTest {

    @Mock StationRepository stationRepo;
    @Mock MunicipalityRepository municipalityRepo;
    @Mock DataSourceRepository dataSourceRepo;
    @InjectMocks StationServiceImpl service;

    @Test
    void create_whenMunicipalityMissing_thenThrow() {
        when(municipalityRepo.findById(5L)).thenReturn(Optional.empty());
        StationCreateDto dto = new StationCreateDto("S", 5L, 1L, 0.0, 0.0, true);
        assertThrows(NotFoundException.class, () -> service.create(dto));
        verify(stationRepo, never()).save(any());
    }

    @Test
    void delete_whenExists_deletes() {
        when(stationRepo.existsById(2L)).thenReturn(true);
        service.delete(2L);
        verify(stationRepo).deleteById(2L);
    }

    @Test
    void delete_whenNotExists_throws() {
        when(stationRepo.existsById(3L)).thenReturn(false);
        assertThrows(NotFoundException.class, () -> service.delete(3L));
    }
}

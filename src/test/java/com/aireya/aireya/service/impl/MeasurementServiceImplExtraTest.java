
package com.aireya.aireya.service.impl;

import com.aireya.aireya.domain.common.Pollutant;
import com.aireya.aireya.domain.model.*;
import com.aireya.aireya.exception.NotFoundException;
import com.aireya.aireya.repository.*;
import com.aireya.aireya.web.dto.MeasurementCreateDto;
import com.aireya.aireya.web.dto.MeasurementDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MeasurementServiceImplExtraTest {

    @Mock MeasurementRepository repo;
    @Mock StationRepository stationRepo;
    @Mock DataSourceRepository dataSourceRepo;
    @InjectMocks MeasurementServiceImpl service;

    @Test
    void create_whenStationMissing_thenThrow() {
        when(stationRepo.findById(10L)).thenReturn(Optional.empty());
        MeasurementCreateDto dto = new MeasurementCreateDto(Pollutant.NO2, 1.0, "ppm", Instant.now(), 10L, 1L);
        assertThrows(NotFoundException.class, () -> service.create(dto));
        verify(repo, never()).save(any());
    }

    @Test
    void create_whenDataSourceMissing_thenThrow() {
        Station s = new Station(); s.setId(1L);
        when(stationRepo.findById(1L)).thenReturn(Optional.of(s));
        when(dataSourceRepo.findById(99L)).thenReturn(Optional.empty());
        MeasurementCreateDto dto = new MeasurementCreateDto(Pollutant.O3, 2.0, "ppm", Instant.now(), 1L, 99L);
        assertThrows(NotFoundException.class, () -> service.create(dto));
        verify(repo, never()).save(any());
    }

    @Test
    void create_success_savesAndReturnsDto() {
        Station s = new Station(); s.setId(1L);
        DataSource ds = new DataSource(); ds.setId(2L);

        when(stationRepo.findById(1L)).thenReturn(Optional.of(s));
        when(dataSourceRepo.findById(2L)).thenReturn(Optional.of(ds));
        when(repo.save(any())).thenAnswer(inv -> {
            Measurement m = inv.getArgument(0);
            m.setId(55L); return m;
        });

        MeasurementCreateDto dto = new MeasurementCreateDto(Pollutant.PM10, 3.0, "µg/m³", Instant.now(), 1L, 2L);
        MeasurementDto md = service.create(dto);
        assertNotNull(md);
        assertEquals(55L, md.id());
    }
}

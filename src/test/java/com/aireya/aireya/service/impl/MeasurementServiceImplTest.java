package com.aireya.aireya.service.impl;

import com.aireya.aireya.domain.common.Pollutant;
import com.aireya.aireya.domain.model.*;
import com.aireya.aireya.exception.NotFoundException;
import com.aireya.aireya.repository.*;
import com.aireya.aireya.web.dto.MeasurementCreateDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.*;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MeasurementServiceImplTest {

    @Mock
    MeasurementRepository repo;
    @Mock
    StationRepository stationRepo;
    @Mock
    DataSourceRepository dsRepo;

    @InjectMocks
    MeasurementServiceImpl service;

    @Test
    void search_success() {
        Station st = new Station();
        st.setId(1L);
        DataSource ds = new DataSource();
        ds.setId(10L);

        Measurement m = new Measurement();
        m.setId(10L);
        m.setStation(st);
        m.setDataSource(ds);

        when(repo.search(any(), any(), any(), any(), any(), any()))
                .thenReturn(new PageImpl<>(List.of(m)));

        var result = service.search(1L, 2L, Pollutant.CO2, Instant.now(), Instant.now(), PageRequest.of(0, 10));

        assertEquals(1, result.getTotalElements());
        verify(repo).search(any(), any(), any(), any(), any(), any());
    }

    @Test
    void getAllMeasurements_success() {
        Station st = new Station();
        st.setId(1L);
        DataSource ds = new DataSource();
        ds.setId(10L);

        Measurement m = new Measurement();
        m.setId(20L);
        m.setStation(st);
        m.setDataSource(ds);

        when(repo.findAll(any(Pageable.class))).thenReturn(new PageImpl<>(List.of(m)));

        var result = service.getAllMeasurements(PageRequest.of(0, 5));
        assertEquals(1, result.getTotalElements());
        verify(repo).findAll(any(Pageable.class));
    }

    @Test
    void createMeasurement_callsCreate() {
        Station st = new Station();
        st.setId(1L);
        DataSource ds = new DataSource();
        ds.setId(2L);
        MeasurementCreateDto dto = new MeasurementCreateDto(Pollutant.CO2, 1.0, "ppm", Instant.now(), 1L, 2L);

        when(stationRepo.findById(1L)).thenReturn(Optional.of(st));
        when(dsRepo.findById(2L)).thenReturn(Optional.of(ds));
        when(repo.save(any())).thenAnswer(inv -> inv.getArgument(0));

        var result = service.createMeasurement(dto);
        assertNotNull(result);
        verify(repo).save(any());
    }

    @Test
    void updateMeasurement_success() {
        Station st = new Station();
        st.setId(1L);
        DataSource ds = new DataSource();
        ds.setId(2L);
        Measurement m = new Measurement();
        m.setId(5L);
        MeasurementCreateDto dto = new MeasurementCreateDto(Pollutant.CO2, 3.0, "ppm", Instant.now(), 1L, 2L);

        when(stationRepo.findById(1L)).thenReturn(Optional.of(st));
        when(dsRepo.findById(2L)).thenReturn(Optional.of(ds));
        when(repo.findById(5L)).thenReturn(Optional.of(m));
        when(repo.save(any())).thenAnswer(inv -> inv.getArgument(0));

        var result = service.updateMeasurement(5L, dto);
        assertNotNull(result);
        verify(repo).save(any());
    }

    @Test
    void deleteMeasurement_success() {
        when(repo.existsById(1L)).thenReturn(true);
        service.deleteMeasurement(1L);
        verify(repo).deleteById(1L);
    }

    @Test
    void deleteMeasurement_notFound_throwsException() {
        when(repo.existsById(1L)).thenReturn(false);
        assertThrows(NotFoundException.class, () -> service.deleteMeasurement(1L));
    }

    @Test
    void updateMeasurement_notFound_throwsException() {
        // Arrange
        MeasurementCreateDto dto = new MeasurementCreateDto(
                Pollutant.CO2, 2.5, "ppm", Instant.now(), 1L, 2L
        );

        Station st = new Station();
        st.setId(1L);
        DataSource ds = new DataSource();
        ds.setId(2L);

        when(stationRepo.findById(1L)).thenReturn(Optional.of(st));
        when(dsRepo.findById(2L)).thenReturn(Optional.of(ds));
        when(repo.findById(99L)).thenReturn(Optional.empty()); // Simula que no existe

        // Act & Assert
        assertThrows(NotFoundException.class, () -> service.updateMeasurement(99L, dto));

        verify(repo, never()).save(any()); // No debe guardar nada
    }

}

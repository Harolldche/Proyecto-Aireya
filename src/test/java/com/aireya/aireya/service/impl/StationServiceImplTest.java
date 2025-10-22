package com.aireya.aireya.service.impl;

import com.aireya.aireya.domain.model.*;
import com.aireya.aireya.exception.NotFoundException;
import com.aireya.aireya.repository.*;
import com.aireya.aireya.web.dto.StationCreateDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.*;

import java.util.Optional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StationServiceImplTest {

    @Mock
    StationRepository stationRepo;
    @Mock
    MunicipalityRepository muniRepo;
    @Mock
    DataSourceRepository dsRepo;

    @InjectMocks
    StationServiceImpl service;

    @Test
    void create_success() {
        Municipality muni = new Municipality();
        muni.setId(1L);
        DataSource ds = new DataSource();
        ds.setId(2L);
        StationCreateDto dto = new StationCreateDto("Est1", 1L, 2L, 10.0, 20.0, true);

        when(muniRepo.findById(1L)).thenReturn(Optional.of(muni));
        when(dsRepo.findById(2L)).thenReturn(Optional.of(ds));
        when(stationRepo.save(any(Station.class))).thenAnswer(inv -> inv.getArgument(0));

        var result = service.create(dto);

        assertNotNull(result);
        verify(stationRepo).save(any(Station.class));
    }

    @Test
    void create_throwsNotFound_whenMunicipioNotFound() {
        StationCreateDto dto = new StationCreateDto("Est1", 1L, 2L, 10.0, 20.0, true);
        when(muniRepo.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> service.create(dto));
    }

    @Test
    void list_whenMunicipalityIdIsNull_callsFindAll() {
        Municipality m = new Municipality();
        m.setId(1L);
        DataSource ds = new DataSource();
        ds.setId(100L);

        Station s = new Station();
        s.setId(10L);
        s.setMunicipality(m);
        s.setDataSource(ds);

        when(stationRepo.findAll(any(Pageable.class)))
                .thenReturn(new PageImpl<>(List.of(s)));

        var result = service.list(null, PageRequest.of(0, 10));
        assertEquals(1, result.getTotalElements());
        verify(stationRepo).findAll(any(Pageable.class));
    }

    @Test
    void list_whenMunicipalityIdProvided_callsFindByMunicipalityIdAndActiveTrue() {
        Municipality m = new Municipality();
        m.setId(2L);
        DataSource ds = new DataSource();
        ds.setId(200L);

        Station s = new Station();
        s.setId(20L);
        s.setMunicipality(m);
        s.setDataSource(ds);

        when(stationRepo.findByMunicipalityIdAndActiveTrue(eq(2L), any(Pageable.class)))
                .thenReturn(new PageImpl<>(List.of(s)));

        var result = service.list(2L, PageRequest.of(0, 10));
        assertEquals(1, result.getTotalElements());
        verify(stationRepo).findByMunicipalityIdAndActiveTrue(eq(2L), any(Pageable.class));
    }

    @Test
    void get_success() {
        Municipality muni = new Municipality();
        muni.setId(5L);
        DataSource ds = new DataSource();
        ds.setId(300L);

        Station s = new Station();
        s.setId(1L);
        s.setMunicipality(muni);
        s.setDataSource(ds);

        when(stationRepo.findById(1L)).thenReturn(Optional.of(s));

        var result = service.get(1L);
        assertNotNull(result);
        verify(stationRepo).findById(1L);
    }

    @Test
    void get_notFound_throwsException() {
        when(stationRepo.findById(99L)).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> service.get(99L));
    }

    @Test
    void update_success() {
        Station s = new Station();
        s.setId(1L);
        Municipality muni = new Municipality();
        muni.setId(1L);
        DataSource ds = new DataSource();
        ds.setId(2L);
        StationCreateDto dto = new StationCreateDto("Updated", 1L, 2L, 15.0, 25.0, false);

        when(stationRepo.findById(1L)).thenReturn(Optional.of(s));
        when(muniRepo.findById(1L)).thenReturn(Optional.of(muni));
        when(dsRepo.findById(2L)).thenReturn(Optional.of(ds));

        var result = service.update(1L, dto);

        assertNotNull(result);
        verify(stationRepo).findById(1L);
        verify(muniRepo).findById(1L);
        verify(dsRepo).findById(2L);
    }

    @Test
    void update_notFoundStation_throwsException() {
        StationCreateDto dto = new StationCreateDto("x", 1L, 1L, 0.0, 0.0, true);
        when(stationRepo.findById(1L)).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> service.update(1L, dto));
    }

    @Test
    void delete_success() {
        when(stationRepo.existsById(1L)).thenReturn(true);
        service.delete(1L);
        verify(stationRepo).deleteById(1L);
    }

    @Test
    void delete_notFound_throwsException() {
        when(stationRepo.existsById(1L)).thenReturn(false);
        assertThrows(NotFoundException.class, () -> service.delete(1L));
    }

    @Test
    void create_throwsNotFound_whenDataSourceNotFound() {
        Municipality muni = new Municipality();
        muni.setId(1L);
        StationCreateDto dto = new StationCreateDto("Est1", 1L, 2L, 10.0, 20.0, true);

        when(muniRepo.findById(1L)).thenReturn(Optional.of(muni));
        when(dsRepo.findById(2L)).thenReturn(Optional.empty()); // Falla aquí

        assertThrows(NotFoundException.class, () -> service.create(dto));
    }

    @Test
    void update_throwsNotFound_whenMunicipalityNotFound() {
        Station s = new Station();
        s.setId(1L);
        StationCreateDto dto = new StationCreateDto("Est2", 5L, 6L, 10.0, 20.0, true);

        when(stationRepo.findById(1L)).thenReturn(Optional.of(s));
        when(muniRepo.findById(5L)).thenReturn(Optional.empty()); // Falla aquí

        assertThrows(NotFoundException.class, () -> service.update(1L, dto));
    }

    @Test
    void update_throwsNotFound_whenDataSourceNotFound() {
        Station s = new Station();
        s.setId(1L);
        Municipality muni = new Municipality();
        muni.setId(5L);
        StationCreateDto dto = new StationCreateDto("Est3", 5L, 9L, 10.0, 20.0, true);

        when(stationRepo.findById(1L)).thenReturn(Optional.of(s));
        when(muniRepo.findById(5L)).thenReturn(Optional.of(muni));
        when(dsRepo.findById(9L)).thenReturn(Optional.empty()); // Falla aquí

        assertThrows(NotFoundException.class, () -> service.update(1L, dto));
    }
}

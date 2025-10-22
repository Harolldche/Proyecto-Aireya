
package com.aireya.aireya.service;

import com.aireya.aireya.domain.common.Pollutant;
import com.aireya.aireya.domain.model.*;
import com.aireya.aireya.exception.NotFoundException;
import com.aireya.aireya.repository.*;
import com.aireya.aireya.service.impl.MeasurementServiceImpl;
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
class MeasurementServiceImplTest {

    @Mock MeasurementRepository repo;
    @Mock StationRepository stationRepo;
    @Mock DataSourceRepository dataSourceRepo;
    @InjectMocks MeasurementServiceImpl service;

    @Test
    void createMeasurementSuccess() {
        Station st = new Station(); st.setId(1L);
        DataSource ds = new DataSource(); ds.setId(2L);

        when(stationRepo.findById(1L)).thenReturn(Optional.of(st));
        when(dataSourceRepo.findById(2L)).thenReturn(Optional.of(ds));
        when(repo.save(any())).thenAnswer(inv -> {
            Measurement m = inv.getArgument(0);
            m.setId(7L); return m;
        });

        MeasurementCreateDto dto = new MeasurementCreateDto(Pollutant.PM10, 5.0, "µg/m³", Instant.now(), 1L, 2L);
        MeasurementDto md = service.create(dto);
        assertNotNull(md);
        assertEquals(7L, md.id());
    }

    @Test
    void createMeasurementStationNotFound() {
        when(stationRepo.findById(9L)).thenReturn(Optional.empty());
        MeasurementCreateDto dto = new MeasurementCreateDto(Pollutant.O3, 1.0, "ppm", Instant.now(), 9L, 2L);
        assertThrows(NotFoundException.class, () -> service.create(dto));
    }
}

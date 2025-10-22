
package com.aireya.aireya.service;

import com.aireya.aireya.domain.model.*;
import com.aireya.aireya.exception.NotFoundException;
import com.aireya.aireya.repository.*;
import com.aireya.aireya.service.impl.StationServiceImpl;
import com.aireya.aireya.web.dto.StationCreateDto;
import com.aireya.aireya.web.dto.StationDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StationServiceImplTest {

    @Mock StationRepository stationRepo;
    @Mock MunicipalityRepository municipalityRepo;
    @Mock DataSourceRepository dataSourceRepo;
    @InjectMocks StationServiceImpl service;

    @Test
    void createStationSuccess() {
        Municipality m = new Municipality(); m.setId(2L);
        DataSource ds = new DataSource(); ds.setId(3L);

        when(municipalityRepo.findById(2L)).thenReturn(Optional.of(m));
        when(dataSourceRepo.findById(3L)).thenReturn(Optional.of(ds));
        when(stationRepo.save(any())).thenAnswer(inv -> {
            Station s = inv.getArgument(0);
            s.setId(99L);
            return s;
        });

        StationCreateDto dto = new StationCreateDto("A", 2L, 3L, 10.0, 20.0, true);
        StationDto res = service.create(dto);
        assertNotNull(res);
        assertEquals(99L, res.id());
    }

    @Test
    void deleteStationNotFound() {
        when(stationRepo.existsById(5L)).thenReturn(false);
        assertThrows(NotFoundException.class, () -> service.delete(5L));
    }
}

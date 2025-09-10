package com.aireya.aireya.service;

import com.aireya.aireya.domain.model.DataSource;
import com.aireya.aireya.domain.model.Municipality;
import com.aireya.aireya.domain.model.Station;
import com.aireya.aireya.repository.DataSourceRepository;
import com.aireya.aireya.repository.MunicipalityRepository;
import com.aireya.aireya.repository.StationRepository;
import com.aireya.aireya.service.impl.StationServiceImpl;
import com.aireya.aireya.web.dto.StationCreateDto;
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
    @Mock MunicipalityRepository muniRepo;
    @Mock DataSourceRepository dsRepo;

    @InjectMocks StationServiceImpl service;

    @Test
    void create_ok() {
        StationCreateDto dto = new StationCreateDto("Estación Centro", 1L, 2L, 13.7, -89.2, true);

        when(muniRepo.findById(1L)).thenReturn(Optional.of(new Municipality()));
        when(dsRepo.findById(2L)).thenReturn(Optional.of(new DataSource()));
        when(stationRepo.save(any())).thenAnswer(inv -> {
            Station s = inv.getArgument(0);
            s.setId(99L);
            return s;
        });

        var out = service.create(dto);
        assertNotNull(out.id());
        assertEquals("Estación Centro", out.name());
    }
}

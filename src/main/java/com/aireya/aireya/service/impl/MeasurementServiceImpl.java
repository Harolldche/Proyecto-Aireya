package com.aireya.aireya.service.impl;

import com.aireya.aireya.domain.common.Pollutant;
import com.aireya.aireya.domain.model.DataSource;
import com.aireya.aireya.domain.model.Measurement;
import com.aireya.aireya.domain.model.Station;
import com.aireya.aireya.exception.NotFoundException;
import com.aireya.aireya.repository.DataSourceRepository;
import com.aireya.aireya.repository.MeasurementRepository;
import com.aireya.aireya.repository.StationRepository;
import com.aireya.aireya.service.MeasurementService;
import com.aireya.aireya.web.dto.MeasurementCreateDto;
import com.aireya.aireya.web.dto.MeasurementDto;
import com.aireya.aireya.web.mapper.MeasurementMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
@RequiredArgsConstructor
@Transactional
public class MeasurementServiceImpl implements MeasurementService {

    private final MeasurementRepository repo;
    private final StationRepository stationRepo;
    private final DataSourceRepository dsRepo;

    @Override
    public MeasurementDto create(MeasurementCreateDto dto) {
        Station st = stationRepo.findById(dto.stationId())
                .orElseThrow(() -> new NotFoundException("Estación no encontrada"));
        DataSource ds = dsRepo.findById(dto.dataSourceId())
                .orElseThrow(() -> new NotFoundException("Fuente de datos no encontrada"));

        Measurement m = new Measurement();
        m.setPollutant(dto.pollutant());
        m.setValue(dto.value());
        m.setUnit(dto.unit());
        m.setTimestampUtc(dto.timestampUtc());
        m.setStation(st);
        m.setDataSource(ds);

        return MeasurementMapper.toDto(repo.save(m));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<MeasurementDto> search(Long municipalityId, Long stationId, Pollutant pollutant,
                                       Instant from, Instant to, Pageable pageable) {
        return repo.search(municipalityId, stationId, pollutant, from, to, pageable)
                .map(MeasurementMapper::toDto);
    }
}

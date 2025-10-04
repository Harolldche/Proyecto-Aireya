package com.aireya.aireya.service.impl;

import com.aireya.aireya.domain.model.DataSource;
import com.aireya.aireya.domain.model.Municipality;
import com.aireya.aireya.domain.model.Station;
import com.aireya.aireya.exception.NotFoundException;
import com.aireya.aireya.repository.DataSourceRepository;
import com.aireya.aireya.repository.MunicipalityRepository;
import com.aireya.aireya.repository.StationRepository;
import com.aireya.aireya.service.StationService;
import com.aireya.aireya.web.dto.StationCreateDto;
import com.aireya.aireya.web.dto.StationDto;
import com.aireya.aireya.web.mapper.StationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class StationServiceImpl implements StationService {

    private final StationRepository stationRepo;
    private final MunicipalityRepository muniRepo;
    private final DataSourceRepository dsRepo;

    @Override
    public StationDto create(StationCreateDto dto) {
        Municipality muni = muniRepo.findById(dto.municipalityId())
                .orElseThrow(() -> new NotFoundException("Municipio no encontrado"));
        DataSource ds = dsRepo.findById(dto.dataSourceId())
                .orElseThrow(() -> new NotFoundException("Fuente de datos no encontrada"));

        Station s = new Station();
        s.setName(dto.name());
        s.setMunicipality(muni);
        s.setDataSource(ds);
        s.setLatitude(dto.latitude());
        s.setLongitude(dto.longitude());
        s.setActive(Boolean.TRUE.equals(dto.active()));

        return StationMapper.toDto(stationRepo.save(s));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<StationDto> list(Long municipalityId, Pageable pageable) {
        Page<Station> page = (municipalityId == null)
                ? stationRepo.findAll(pageable)
                : stationRepo.findByMunicipalityIdAndActiveTrue(municipalityId, pageable);
        return page.map(StationMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public StationDto get(Long id) {
        Station s = stationRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Estación no encontrada"));
        return StationMapper.toDto(s);
    }

    @Override
    public StationDto update(Long id, StationCreateDto dto) {
        Station s = stationRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Estación no encontrada"));

        var muni = muniRepo.findById(dto.municipalityId())
                .orElseThrow(() -> new NotFoundException("Municipio no encontrado"));
        var ds = dsRepo.findById(dto.dataSourceId())
                .orElseThrow(() -> new NotFoundException("Fuente de datos no encontrada"));

        s.setName(dto.name());
        s.setMunicipality(muni);
        s.setDataSource(ds);
        s.setLatitude(dto.latitude());
        s.setLongitude(dto.longitude());
        s.setActive(Boolean.TRUE.equals(dto.active()));

        return StationMapper.toDto(s);
    }

    @Override
    public void delete(Long id) {
        if (!stationRepo.existsById(id)) throw new NotFoundException("Estación no encontrada");
        stationRepo.deleteById(id);
    }
}

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

    /**
     * Crear una nueva medición.
     */
    @Override
    public MeasurementDto create(MeasurementCreateDto dto) {
        return saveMeasurement(dto, null);
    }

    /**
     * Búsqueda avanzada con filtros (municipio, estación, contaminante, rango de fechas).
     */
    @Override
    @Transactional(readOnly = true)
    public Page<MeasurementDto> search(Long municipalityId, Long stationId, Pollutant pollutant,
                                       Instant from, Instant to, Pageable pageable) {
        return repo.search(municipalityId, stationId, pollutant, from, to, pageable)
                .map(MeasurementMapper::toDto);
    }

    /**
     * Obtener todas las mediciones con paginación.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<MeasurementDto> getAllMeasurements(Pageable pageable) {
        return repo.findAll(pageable).map(MeasurementMapper::toDto);
    }

    /**
     * Crear una nueva medición (alias de create, usado en el controller).
     */
    @Override
    public MeasurementDto createMeasurement(MeasurementCreateDto dto) {
        return create(dto);
    }

    /**
     * Actualizar todos los campos de una medición existente.
     */
    @Override
    public MeasurementDto updateMeasurement(Long id, MeasurementCreateDto dto) {
        return saveMeasurement(dto, id);
    }

    /**
     * Eliminar una medición por ID.
     */
    @Override
    public void deleteMeasurement(Long id) {
        if (!repo.existsById(id)) {
            throw new NotFoundException("Medición con ID " + id + " no encontrada");
        }
        repo.deleteById(id);
    }

    /**
     * Método privado reutilizable para crear o actualizar.
     */
    private MeasurementDto saveMeasurement(MeasurementCreateDto dto, Long idToUpdate) {
        Station st = stationRepo.findById(dto.stationId())
                .orElseThrow(() -> new NotFoundException("Estación no encontrada"));
        DataSource ds = dsRepo.findById(dto.dataSourceId())
                .orElseThrow(() -> new NotFoundException("Fuente de datos no encontrada"));

        Measurement m;
        if (idToUpdate != null) {
            // Si estamos actualizando
            m = repo.findById(idToUpdate)
                    .orElseThrow(() -> new NotFoundException("Medición con ID " + idToUpdate + " no encontrada"));
        } else {
            // Si estamos creando
            m = new Measurement();
        }

        // Asignar campos
        m.setPollutant(dto.pollutant());
        m.setValue(dto.value());
        m.setUnit(dto.unit());
        m.setTimestampUtc(dto.timestampUtc());
        m.setStation(st);
        m.setDataSource(ds);

        return MeasurementMapper.toDto(repo.save(m));
    }
}

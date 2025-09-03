package com.aireya.aireya.web.mapper;

import com.aireya.aireya.domain.model.Measurement;
import com.aireya.aireya.web.dto.MeasurementDto;

public class MeasurementMapper {
    public static MeasurementDto toDto(Measurement m) {
        return new MeasurementDto(
                m.getId(), m.getPollutant(), m.getValue(), m.getUnit(),
                m.getTimestampUtc(), m.getStation().getId(), m.getDataSource().getId()
        );
    }
}

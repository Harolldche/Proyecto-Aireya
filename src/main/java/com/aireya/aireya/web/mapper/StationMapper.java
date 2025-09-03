package com.aireya.aireya.web.mapper;

import com.aireya.aireya.domain.model.Station;
import com.aireya.aireya.web.dto.StationDto;

public class StationMapper {
    public static StationDto toDto(Station s) {
        return new StationDto(
                s.getId(), s.getName(),
                s.getMunicipality().getId(),
                s.getDataSource().getId(),
                s.getLatitude(), s.getLongitude(), s.getActive()
        );
    }
}

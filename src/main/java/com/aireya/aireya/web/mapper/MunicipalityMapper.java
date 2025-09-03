package com.aireya.aireya.web.mapper;

import com.aireya.aireya.domain.model.Municipality;
import com.aireya.aireya.web.dto.MunicipalityDto;

public class MunicipalityMapper {
    public static MunicipalityDto toDto(Municipality m) {
        return new MunicipalityDto(m.getId(), m.getName(), m.getDepartment().getId());
    }
}

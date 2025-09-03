package com.aireya.aireya.web.mapper;

import com.aireya.aireya.domain.model.DataSource;
import com.aireya.aireya.web.dto.DataSourceDto;

public class DataSourceMapper {
    public static DataSourceDto toDto(DataSource s) {
        return new DataSourceDto(s.getId(), s.getCode(), s.getDescription(), s.getContactUrl());
    }
}

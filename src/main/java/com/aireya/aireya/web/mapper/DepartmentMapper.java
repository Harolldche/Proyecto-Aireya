package com.aireya.aireya.web.mapper;

import com.aireya.aireya.domain.model.Department;
import com.aireya.aireya.web.dto.DepartmentDto;

public class DepartmentMapper {
    public static DepartmentDto toDto(Department d) {
        return new DepartmentDto(d.getId(), d.getName());
    }
}

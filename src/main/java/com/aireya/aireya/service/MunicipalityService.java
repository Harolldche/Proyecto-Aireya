package com.aireya.aireya.service;

import com.aireya.aireya.web.dto.MunicipalityDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MunicipalityService {
    Page<MunicipalityDto> list(Long departmentId, Pageable pageable);
}

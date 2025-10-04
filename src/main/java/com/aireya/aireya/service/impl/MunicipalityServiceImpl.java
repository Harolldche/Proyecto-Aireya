package com.aireya.aireya.service.impl;

import com.aireya.aireya.repository.MunicipalityRepository;
import com.aireya.aireya.service.MunicipalityService;
import com.aireya.aireya.web.dto.MunicipalityDto;
import com.aireya.aireya.web.mapper.MunicipalityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MunicipalityServiceImpl implements MunicipalityService {
    private final MunicipalityRepository repo;

    @Override
    public Page<MunicipalityDto> list(Long departmentId, Pageable pageable) {
        var page = (departmentId == null) ? repo.findAll(pageable)
                : repo.findByDepartmentId(departmentId, pageable);
        return page.map(MunicipalityMapper::toDto);
    }
}

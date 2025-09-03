package com.aireya.aireya.service.impl;

import com.aireya.aireya.repository.DepartmentRepository;
import com.aireya.aireya.service.DepartmentService;
import com.aireya.aireya.web.dto.DepartmentDto;
import com.aireya.aireya.web.mapper.DepartmentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository repo;

    @Override
    public List<DepartmentDto> listAll() {
        return repo.findAll().stream().map(DepartmentMapper::toDto).toList();
    }
}

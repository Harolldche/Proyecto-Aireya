package com.aireya.aireya.service.impl;

import com.aireya.aireya.repository.DataSourceRepository;
import com.aireya.aireya.service.DataSourceService;
import com.aireya.aireya.web.dto.DataSourceDto;
import com.aireya.aireya.web.mapper.DataSourceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DataSourceServiceImpl implements DataSourceService {
    private final DataSourceRepository repo;

    @Override
    public List<DataSourceDto> listAll() {
        return repo.findAll().stream().map(DataSourceMapper::toDto).toList();
    }
}

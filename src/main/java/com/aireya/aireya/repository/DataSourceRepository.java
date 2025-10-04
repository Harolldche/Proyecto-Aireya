package com.aireya.aireya.repository;

import com.aireya.aireya.domain.model.DataSource;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface DataSourceRepository extends JpaRepository<DataSource, Long> {
    Optional<DataSource> findByCode(String code);
}

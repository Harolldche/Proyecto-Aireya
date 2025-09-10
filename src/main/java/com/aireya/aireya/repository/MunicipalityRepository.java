package com.aireya.aireya.repository;

import com.aireya.aireya.domain.model.Municipality;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MunicipalityRepository extends JpaRepository<Municipality, Long> {
    Page<Municipality> findByDepartmentId(Long departmentId, Pageable pageable);
}

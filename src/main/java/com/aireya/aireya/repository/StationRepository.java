package com.aireya.aireya.repository;

import com.aireya.aireya.domain.model.Station;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station, Long> {
    Page<Station> findByMunicipalityIdAndActiveTrue(Long municipalityId, Pageable pageable);
}

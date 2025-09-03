package com.aireya.aireya.repository;

import com.aireya.aireya.domain.common.Pollutant;
import com.aireya.aireya.domain.model.Measurement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Instant;

public interface MeasurementRepository extends org.springframework.data.jpa.repository.JpaRepository<Measurement, Long> {

    @Query("""
     select m from Measurement m
     where (:municipalityId is null or m.station.municipality.id = :municipalityId)
       and (:stationId is null or m.station.id = :stationId)
       and (:pollutant is null or m.pollutant = :pollutant)
       and (:fromTs is null or m.timestampUtc >= :fromTs)
       and (:toTs is null or m.timestampUtc <= :toTs)
    """)
    Page<Measurement> search(@Param("municipalityId") Long municipalityId,
                             @Param("stationId") Long stationId,
                             @Param("pollutant") Pollutant pollutant,
                             @Param("fromTs") Instant from,
                             @Param("toTs") Instant to,
                             Pageable pageable);
}

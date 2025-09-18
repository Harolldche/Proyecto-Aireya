package com.aireya.aireya.domain.model;

import com.aireya.aireya.domain.common.Pollutant;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.Instant;

/**
 * Medición puntual de un contaminante en una estación, en UTC. Es decir, mediciones de aire
 */
@Entity
@Table(name = "measurements",
       indexes = {
         @Index(name = "idx_measurement_station_ts", columnList = "station_id, timestamp_utc"), //acelera las búsquedas por estación + tiempo.
         @Index(name = "idx_measurement_pollutant_ts", columnList = "pollutant, timestamp_utc") //acelera las búsquedas por contaminante + tiempo.
       })
@Getter @Setter
public class Measurement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private Pollutant pollutant;

    @Column(nullable = false)
    private Double value;

    @Column(nullable = false, length = 16)
    private String unit;

    @Column(name = "timestamp_utc", nullable = false)
    private Instant timestampUtc;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "station_id")
    private Station station;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "data_source_id")
    private DataSource dataSource;
}

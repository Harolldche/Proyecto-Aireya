package com.aireya.aireya.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Estación de medición dentro de un municipio.
 */
@Entity
@Table(name = "stations")
@Getter @Setter
public class Station {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String name;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "municipality_id")
    private Municipality municipality;

    private Double latitude;
    private Double longitude;

    @Column(nullable = false)
    private Boolean active = true;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "data_source_id")
    private DataSource dataSource;
}

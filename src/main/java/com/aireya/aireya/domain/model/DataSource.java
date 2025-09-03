package com.aireya.aireya.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Fuente de datos (IQAIR, OPENAQ, MARN, etc).
 */
@Entity
@Table(name = "data_sources")
@Getter @Setter
public class DataSource {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 60)
    private String code;

    @Column(length = 255)
    private String description;

    @Column(length = 255)
    private String contactUrl;
}

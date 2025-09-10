package com.aireya.aireya.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Departamento de El Salvador (ej. San Salvador).
 */
@Entity
@Table(name = "departments")
@Getter @Setter
public class Department {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 80)
    private String name;
}

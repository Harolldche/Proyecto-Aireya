package com.aireya.aireya.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Municipio vinculado a un departamento.
 */
@Entity
@Table(name = "municipalities",
       uniqueConstraints = @UniqueConstraint(columnNames = {"name", "department_id"}))
@Getter @Setter
public class Municipality {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;
}

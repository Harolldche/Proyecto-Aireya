package com.aireya.aireya.web.validation;

import com.aireya.aireya.domain.common.Pollutant;
import com.aireya.aireya.web.dto.MeasurementCreateDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Lógica de validación simple para unidad versus contaminante.
 */
public class MeasurementUnitValidator implements ConstraintValidator<ValidMeasurementUnit, MeasurementCreateDto> {

    @Override
    public boolean isValid(MeasurementCreateDto dto, ConstraintValidatorContext context) {
        if (dto == null || dto.pollutant() == null || dto.unit() == null) return true;
        String u = dto.unit().toLowerCase();
        Pollutant p = dto.pollutant();
        return switch (p) {
            case PM2_5, PM10 -> (u.contains("µg/m³") || u.contains("ug/m3"));
            case CO2, NO2, O3 -> (u.equals("ppm") || u.equals("ppb"));
            default -> false; // cobertura completa para Jacoco
        };
    }
}

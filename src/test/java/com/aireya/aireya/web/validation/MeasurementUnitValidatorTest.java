package com.aireya.aireya.web.validation;

import com.aireya.aireya.domain.common.Pollutant;
import com.aireya.aireya.web.dto.MeasurementCreateDto;
import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.Test;


import java.time.Instant;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

class MeasurementUnitValidatorTest {

    private final MeasurementUnitValidator validator = new MeasurementUnitValidator();
    private final ConstraintValidatorContext ctx = null;

    @Test void testValidPm25Unit() {
        var dto = new MeasurementCreateDto(Pollutant.PM2_5, 12.0, "µg/m³", Instant.now(), 1L, 1L);
        assertTrue(validator.isValid(dto, ctx));
    }

    @Test void testInvalidPm25Unit() {
        var dto = new MeasurementCreateDto(Pollutant.PM2_5, 12.0, "ppm", Instant.now(), 1L, 1L);
        assertFalse(validator.isValid(dto, ctx));
    }

    @Test void testValidPm10UnitUg() {
        var dto = new MeasurementCreateDto(Pollutant.PM10, 10.0, "ug/m3", Instant.now(), 1L, 1L);
        assertTrue(validator.isValid(dto, ctx));
    }

    @Test void testInvalidPm10Unit() {
        var dto = new MeasurementCreateDto(Pollutant.PM10, 10.0, "ppm", Instant.now(), 1L, 1L);
        assertFalse(validator.isValid(dto, ctx));
    }

    @Test void testValidCo2Unit() {
        var dto = new MeasurementCreateDto(Pollutant.CO2, 0.5, "ppm", Instant.now(), 1L, 1L);
        assertTrue(validator.isValid(dto, ctx));
    }

    @Test void testValidNo2UnitPpb() {
        var dto = new MeasurementCreateDto(Pollutant.NO2, 0.2, "ppb", Instant.now(), 1L, 1L);
        assertTrue(validator.isValid(dto, ctx));
    }

    @Test void testInvalidNo2Unit() {
        var dto = new MeasurementCreateDto(Pollutant.NO2, 0.2, "ug/m3", Instant.now(), 1L, 1L);
        assertFalse(validator.isValid(dto, ctx));
    }

    @Test void testValidO3UnitPpm() {
        var dto = new MeasurementCreateDto(Pollutant.O3, 0.3, "ppm", Instant.now(), 1L, 1L);
        assertTrue(validator.isValid(dto, ctx));
    }

    @Test void testInvalidO3Unit() {
        var dto = new MeasurementCreateDto(Pollutant.O3, 0.3, "µg/m³", Instant.now(), 1L, 1L);
        assertFalse(validator.isValid(dto, ctx));
    }

    @Test void testDtoIsNull() {
        assertTrue(validator.isValid(null, ctx));
    }

    @Test void testPollutantIsNull() {
        var dto = new MeasurementCreateDto(null, 1.0, "ppm", Instant.now(), 1L, 1L);
        assertTrue(validator.isValid(dto, ctx));
    }

    @Test void testUnitIsNull() {
        var dto = new MeasurementCreateDto(Pollutant.CO2, 1.0, null, Instant.now(), 1L, 1L);
        assertTrue(validator.isValid(dto, ctx));
    }

    @Test void testValidCo2UnitWithPpbUpperCase() {
        var dto = new MeasurementCreateDto(Pollutant.CO2, 1.0, "PPB", Instant.now(), 1L, 1L);
        assertTrue(validator.isValid(dto, ctx));
    }

    @Test void testInvalidUnitWithUnexpectedCase() {
        var dto = new MeasurementCreateDto(Pollutant.PM10, 10.0, "PPM", Instant.now(), 1L, 1L);
        assertFalse(validator.isValid(dto, ctx));
    }

    @Test void testInvalidCo2Unit() {
        var dto = new MeasurementCreateDto(Pollutant.CO2, 1.0, "g/m3", Instant.now(), 1L, 1L);
        assertFalse(validator.isValid(dto, ctx));
    }

    @Test void testNullPollutantReturnsTrue() {
    MeasurementCreateDto dto = new MeasurementCreateDto(
        null,              // pollutant es null
        10.0,
        "ppm",
        Instant.now(),
        1L,
        1L
    );
    assertTrue(validator.isValid(dto, ctx));
    }

    @Test void testNullUnitReturnsTrue() {
    MeasurementCreateDto dto = new MeasurementCreateDto(
        Pollutant.CO2,
        10.0,
        null,              // unit es null
        Instant.now(),
        1L,
        1L
    );
    assertTrue(validator.isValid(dto, ctx));
    }

    @Test void testValidPm10Unit() {
        MeasurementCreateDto dto = new MeasurementCreateDto(
            Pollutant.PM10,
            10.0,
            "ug/m3",  // valid unit para PM10
            Instant.now(),
            1L,
            1L
        );
        assertTrue(validator.isValid(dto, ctx));
    }

    @Test void testValidNo2Unit() {
        MeasurementCreateDto dto = new MeasurementCreateDto(
            Pollutant.NO2,
            0.01,
            "ppb",  // valid unit para NO2
            Instant.now(),
            1L,
            1L
        );
        assertTrue(validator.isValid(dto, ctx));
    }

    @Test void testValidO3Unit() {
        MeasurementCreateDto dto = new MeasurementCreateDto(
            Pollutant.O3,
            0.05,
            "ppm",  // valid unit para O3
            Instant.now(),
            1L,
            1L
        );
        assertTrue(validator.isValid(dto, ctx));
    }
}

package com.aireya.aireya.web.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

/**
 * Verifica que la unidad sea coherente con el contaminante:
 * PM -> µg/m³; Gases -> ppm/ppb.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = MeasurementUnitValidator.class)
public @interface ValidMeasurementUnit {
    String message() default "Unidad inválida para el contaminante";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

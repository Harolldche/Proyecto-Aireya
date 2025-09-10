package com.aireya.aireya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Punto de arranque de la API. Escanea todo el paquete com.aireya.aireya.
 */
@SpringBootApplication
public class AireYaApplication {
    public static void main(String[] args) {
        SpringApplication.run(AireYaApplication.class, args);
    }
}

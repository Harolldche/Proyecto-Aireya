package com.aireya.aireya.config;

// Importaciones necesarias para la configuración y las pruebas
import io.swagger.v3.oas.models.OpenAPI;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de prueba unitaria para la configuración de OpenAPI (Swagger).
 * Se encarga de validar que el bean de configuración se cree correctamente
 * y que los valores básicos de la documentación de la API estén definidos.
 */
class OpenApiConfigTest {

    /**
     * Prueba que verifica que el método apiInfo() de la clase OpenApiConfig
     * retorna un objeto OpenAPI correctamente inicializado con la información esperada.
     */
    @Test
    void apiInfoBeanExists() {
        // Se crea una instancia de la clase de configuración
        OpenApiConfig config = new OpenApiConfig();

        // Se obtiene el objeto OpenAPI generado por el método apiInfo()
        OpenAPI api = config.apiInfo();

        // Se comprueba que el objeto OpenAPI no sea nulo
        assertNotNull(api);

        // Se comprueba que el objeto contenga información (campo "info" inicializado)
        assertNotNull(api.getInfo());

        // Se valida que el título del API coincida con el valor esperado
        assertEquals("AireYa - API de Calidad del Aire (SV)", api.getInfo().getTitle());
    }

    /**
     * Prueba simple para cubrir la ejecución del constructor de OpenApiConfig.
     * Se asegura que la clase pueda instanciarse correctamente sin lanzar excepciones.
     */
    @Test
    void constructorCovered() {
        new OpenApiConfig(); // Instancia directa para cubrir el constructor en los tests
    }
}

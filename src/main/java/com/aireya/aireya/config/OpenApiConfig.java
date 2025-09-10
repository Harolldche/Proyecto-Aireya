package com.aireya.aireya.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Swagger UI: /swagger-ui/index.html
 */
@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info()
                        .title("AireYa - API de Calidad del Aire (SV)")
                        .version("v1")
                        .description("Centraliza mediciones de PM2.5, PM10, CO2, NO2 y O3 por municipio de El Salvador.")
                        .contact(new Contact().name("AireYa").url("https://github.com/")))
                .addServersItem(new Server().url("/").description("Local"));
    }
}

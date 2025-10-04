package com.aireya.aireya.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Swagger UI: http://localhost:8080/swagger-ui/index.html
 * RFC 6750 – The OAuth 2.0 Authorization Framework: Bearer Token Usage
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI apiInfo() {
        final String securitySchemeName = "bearerAuth";

        return new OpenAPI()
                .info(new Info()
                        .title("AireYa - API de Calidad del Aire (SV)")
                        .version("v1")
                        .description("Centraliza mediciones de PM2.5, PM10, CO2, NO2 y O3 por municipio de El Salvador.")
                        .contact(new Contact()
                                .name("AireYa")
                                .url("https://github.com/")))
                .addServersItem(new Server().url("/").description("Local"))
                // Configuración de seguridad para JWT
                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
                .components(new io.swagger.v3.oas.models.Components()
                        .addSecuritySchemes(securitySchemeName,
                                new SecurityScheme()
                                        .name(securitySchemeName)
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                                        .description("Ingrese su token de acceso JWT proporcionado al iniciar sesión")
                        ));
    }
}

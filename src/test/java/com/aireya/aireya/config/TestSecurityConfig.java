package com.aireya.aireya.config;

// Importaciones necesarias para la configuración de seguridad en entorno de pruebas
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Clase de configuración de seguridad utilizada exclusivamente en el contexto de pruebas.
 * 
 * Esta clase anula la configuración de seguridad original de la aplicación
 * para permitir el acceso libre a todas las rutas durante la ejecución de los tests.
 * 
 * De esta forma, las pruebas no se ven afectadas por la autenticación o el control de acceso.
 */
@TestConfiguration // Indica que esta configuración se aplica solo durante los tests
public class TestSecurityConfig {

    /**
     * Define un bean de tipo SecurityFilterChain con un nombre distinto al original.
     * Esto evita conflictos con la configuración de seguridad principal.
     *
     * @param http el objeto HttpSecurity proporcionado por Spring Security
     * @return una cadena de filtros de seguridad personalizada para pruebas
     * @throws Exception si ocurre algún error en la configuración
     */
    @Bean(name = "testSecurityFilterChain") // nombre distinto al original
    public SecurityFilterChain testSecurityFilterChain(HttpSecurity http) throws Exception {
        http
            // Se desactiva la protección CSRF (Cross-Site Request Forgery)
            // ya que en las pruebas no es necesaria
            .csrf(csrf -> csrf.disable())

            // Se permite el acceso a cualquier petición sin autenticación
            .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())

            // Se deshabilitan los encabezados de frameOptions para permitir
            // el uso de recursos embebidos (por ejemplo, la consola H2)
            .headers(headers -> headers.frameOptions().disable());

        // Se construye y retorna la configuración de seguridad final
        return http.build();
    }
}

package com.aireya.aireya.security;

// Importaciones necesarias para pruebas con Mockito y JUnit
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.AuthenticationException;

import java.io.IOException;

import static org.mockito.Mockito.*;

/**
 * Clase de prueba unitaria para JwtAuthenticationEntryPoint.
 * 
 * Este componente de Spring Security se encarga de manejar los intentos
 * de acceso no autorizados (cuando un usuario no autenticado intenta acceder
 * a un recurso protegido con JWT).
 */
class JwtAuthenticationEntryPointTest {

    // Instancia del componente que se va a probar
    private JwtAuthenticationEntryPoint entryPoint;

    // Mocks de los objetos necesarios para la prueba
    @Mock
    private HttpServletRequest request; // Simula la solicitud HTTP

    @Mock
    private HttpServletResponse response; // Simula la respuesta HTTP

    @Mock
    private AuthenticationException authException; // Simula una excepción de autenticación

    /**
     * Inicializa los mocks y la instancia del componente antes de cada prueba.
     */
    @BeforeEach
    void setUp() {
        // Inicializa los mocks declarados con @Mock
        MockitoAnnotations.openMocks(this);
        // Crea una nueva instancia del entry point
        entryPoint = new JwtAuthenticationEntryPoint();
    }

    /**
     * Verifica que el método commence() envía correctamente una respuesta 401
     * cuando ocurre un intento de acceso no autorizado.
     *
     * @throws IOException si ocurre un error al enviar la respuesta
     * @throws ServletException si ocurre un error del servlet
     */
    @Test
    void commence_sendsUnauthorizedError() throws IOException, ServletException {
        // Simula el mensaje de error de la excepción
        when(authException.getMessage()).thenReturn("Unauthorized access");

        // Ejecuta el método que maneja el acceso no autorizado
        entryPoint.commence(request, response, authException);

        // Verifica que se haya enviado un error HTTP 401 con el mensaje esperado
        verify(response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error: Unauthorized");
    }
}

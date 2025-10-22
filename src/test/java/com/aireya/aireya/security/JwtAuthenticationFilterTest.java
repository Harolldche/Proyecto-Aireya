package com.aireya.aireya.security;

// Importaciones necesarias para pruebas unitarias con JUnit y Mockito
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase JwtAuthenticationFilter.
 * 
 * Esta clase valida el comportamiento del filtro que intercepta las peticiones HTTP
 * y se encarga de autenticar al usuario a partir del token JWT incluido en el header.
 * 
 * Se cubren los distintos escenarios: token válido, inválido, ausente o con formato incorrecto.
 */
@ExtendWith(MockitoExtension.class)
class JwtAuthenticationFilterTest {

    // Mocks de las dependencias necesarias para el filtro
    @Mock
    JwtUtil jwtUtil; // Utilidad para validar y obtener información del token JWT

    @Mock
    UserDetailsService userDetailsService; // Servicio que carga los detalles del usuario

    @Mock
    HttpServletRequest request; // Simulación de la solicitud HTTP

    @Mock
    HttpServletResponse response; // Simulación de la respuesta HTTP

    @Mock
    FilterChain chain; // Cadena de filtros (permite continuar el flujo de ejecución)

    // Instancia del filtro a probar
    JwtAuthenticationFilter filter;

    /**
     * Inicializa el filtro antes de cada prueba y limpia el contexto de seguridad.
     */
    @BeforeEach
    void setUp() {
        filter = new JwtAuthenticationFilter(jwtUtil, userDetailsService);
        SecurityContextHolder.clearContext(); // Limpia autenticaciones previas
    }

    /**
     * Caso: el token JWT es válido.
     * Se espera que el filtro autentique al usuario correctamente
     * y establezca la autenticación en el contexto de seguridad.
     */
    @Test
    void doFilter_validToken_setsAuthentication() throws ServletException, IOException {
        // Simula un header Authorization con un token válido
        when(request.getHeader("Authorization")).thenReturn("Bearer token");

        // Define el comportamiento simulado del JwtUtil
        when(jwtUtil.getUsernameFromToken("token")).thenReturn("user");
        when(jwtUtil.getRoleFromToken("token")).thenReturn("ADMIN");
        when(jwtUtil.validateToken("token")).thenReturn(true);

        // Simula un usuario cargado desde UserDetailsService
        var user = new org.springframework.security.core.userdetails.User(
                "user", "p", java.util.List.of());
        when(userDetailsService.loadUserByUsername("user")).thenReturn(user);

        // Ejecuta el filtro
        filter.doFilterInternal(request, response, chain);

        // Verifica que el contexto de seguridad tenga autenticación activa
        assertNotNull(SecurityContextHolder.getContext().getAuthentication());
        assertEquals("user", SecurityContextHolder.getContext().getAuthentication().getName());

        // Comprueba que el flujo continúe con el siguiente filtro
        verify(chain).doFilter(request, response);
    }

    /**
     * Caso: el token JWT es inválido.
     * Se espera que no se establezca autenticación y se limpie el contexto.
     */
    @Test
    void doFilter_invalidToken_clearsContext() throws ServletException, IOException {
        when(request.getHeader("Authorization")).thenReturn("Bearer t");
        lenient().when(jwtUtil.getUsernameFromToken("t")).thenReturn("user");
        when(jwtUtil.validateToken("t")).thenReturn(false);

        filter.doFilterInternal(request, response, chain);

        // El contexto de seguridad debe permanecer vacío
        assertNull(SecurityContextHolder.getContext().getAuthentication());
        verify(chain).doFilter(request, response);
    }

    /**
     * Caso: no hay header Authorization en la solicitud.
     * El filtro debe dejar pasar la petición sin establecer autenticación.
     */
    @Test
    void doFilter_noAuthorizationHeader_passesThrough() throws ServletException, IOException {
        when(request.getHeader("Authorization")).thenReturn(null);

        filter.doFilterInternal(request, response, chain);

        // No debe haber autenticación activa
        assertNull(SecurityContextHolder.getContext().getAuthentication());
        verify(chain).doFilter(request, response);
    }

    /**
     * Caso: el header Authorization existe pero no comienza con "Bearer".
     * Se espera que el filtro simplemente deje continuar la solicitud.
     */
    @Test
    void doFilter_authorizationHeaderWithoutBearer_passesThrough() throws ServletException, IOException {
        when(request.getHeader("Authorization")).thenReturn("Basic abcdef");

        filter.doFilterInternal(request, response, chain);

        // El contexto de seguridad no debe tener autenticación
        assertNull(SecurityContextHolder.getContext().getAuthentication());
        verify(chain).doFilter(request, response);
    }
}

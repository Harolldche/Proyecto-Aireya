package com.aireya.aireya;

import com.aireya.aireya.security.JwtUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase JwtUtil.
 * 
 * Esta clase verifica la generación, extracción y validación de tokens JWT.
 * Es similar a la otra prueba de JwtUtil pero con un enfoque adicional
 * en la integración completa del flujo de token.
 */
public class JwtUtilTest {

    // Instancia de la utilidad de JWT que se va a probar
    private JwtUtil jwtUtil;

    /**
     * Configuración inicial antes de cada prueba.
     * Se crea un objeto JwtUtil con una clave secreta y tiempo de expiración definidos.
     */
    @BeforeEach
    public void setUp() {
        // Clave secreta para pruebas (debe ser suficientemente larga para HS256)
        String secretKey = "MyTestJwtSecretKeyForHS256MyTestJwtSecretKeyForHS256";
        // Tiempo de expiración en milisegundos (1 hora)
        long expirationMs = 3600000;

        // Inicializa JwtUtil con los parámetros definidos
        jwtUtil = new JwtUtil(secretKey, expirationMs);
    }

    /**
     * Prueba completa del flujo: generar token, extraer información y validar.
     */
    @Test
    public void testGenerateAndValidateToken() {
        String username = "usuarioPrueba"; // Nombre de usuario para el token
        String role = "ROLE_USER";          // Rol que se incluirá en el token

        // Genera un token JWT con los datos especificados
        String token = jwtUtil.generateToken(username, role);

        // Verifica que el token generado no sea nulo
        assertNotNull(token, "El token no debe ser nulo");

        // Extrae el nombre de usuario del token
        String extractedUsername = jwtUtil.getUsernameFromToken(token);

        // Verifica que el username extraído coincida con el original
        assertEquals(username, extractedUsername, "El nombre de usuario extraído debe coincidir");

        // Valida que el token sea correcto y válido
        boolean isValid = jwtUtil.validateToken(token);
        assertTrue(isValid, "El token debería ser válido");
    }
}

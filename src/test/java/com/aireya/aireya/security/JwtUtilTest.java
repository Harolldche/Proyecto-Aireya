package com.aireya.aireya.security;

import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.security.Key;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de prueba para la utilidad JwtUtil.
 * Verifica la correcta generación, extracción y validación de tokens JWT.
 */
class JwtUtilTest {

    // Instancia de la clase que se va a probar
    private JwtUtil jwtUtil;

    // Clave secreta de 32 caracteres (requerida para el algoritmo HS256)
    private final String secret = "01234567890123456789012345678901";

    // Tiempo de expiración del token en milisegundos (1 hora)
    private final long expirationMs = 3600000;

    /**
     * Configuración inicial antes de cada prueba.
     * Se crea una nueva instancia de JwtUtil con la clave y expiración definidas.
     */
    @BeforeEach
    void setUp() {
        jwtUtil = new JwtUtil(secret, expirationMs);
    }

    /**
     * Prueba que verifica que el método generateToken crea un token válido.
     */
    @Test
    void generateToken_createsValidToken() {
        // Generamos un token con un usuario y un rol
        String token = jwtUtil.generateToken("user", "ADMIN");

        // Validamos que el token no sea nulo y tenga contenido
        assertNotNull(token);
        assertTrue(token.length() > 0);
    }

    /**
     * Prueba que extrae correctamente el nombre de usuario del token.
     */
    @Test
    void getUsernameFromToken_returnsUsername() {
        // Generamos el token
        String token = jwtUtil.generateToken("user", "ADMIN");

        // Obtenemos el nombre de usuario del token
        String username = jwtUtil.getUsernameFromToken(token);

        // Comprobamos que sea el usuario correcto
        assertEquals("user", username);
    }

    /**
     * Prueba que obtiene correctamente el rol almacenado en el token.
     */
    @Test
    void getRoleFromToken_returnsRole() {
        // Generamos un token con un rol específico
        String token = jwtUtil.generateToken("user", "ADMIN");

        // Obtenemos el rol
        String role = jwtUtil.getRoleFromToken(token);

        // Verificamos que sea el esperado
        assertEquals("ADMIN", role);
    }

    /**
     * Prueba que devuelve null si el token no contiene un rol.
     */
    @Test
    void getRoleFromToken_returnsNullIfNoRole() {
        // Creamos una clave válida con la librería JJWT
        Key key = Keys.hmacShaKeyFor(secret.getBytes());

        // Generamos un token sin la claim "role"
        String token = io.jsonwebtoken.Jwts.builder()
                .setSubject("user")
                .signWith(key)
                .compact();

        // Intentamos obtener el rol
        String role = jwtUtil.getRoleFromToken(token);

        // Debe retornar null, ya que no hay rol definido
        assertNull(role);
    }

    /**
     * Prueba que valida correctamente un token válido.
     */
    @Test
    void validateToken_returnsTrueForValidToken() {
        // Generamos un token válido
        String token = jwtUtil.generateToken("user", "ADMIN");

        // El método debe retornar true al validarlo
        assertTrue(jwtUtil.validateToken(token));
    }

    /**
     * Prueba que retorna false para un token inválido.
     */
    @Test
    void validateToken_returnsFalseForInvalidToken() {
        // Token manipulado o con formato incorrecto
        String invalidToken = "invalid.token.value";

        // La validación debe fallar
        assertFalse(jwtUtil.validateToken(invalidToken));
    }

    /**
     * Prueba que arroja excepción al intentar obtener el username de un token inválido.
     */
    @Test
    void getUsernameFromToken_throwsForInvalidToken() {
        String invalidToken = "invalid.token.value";

        // Debe lanzar una excepción JwtException
        assertThrows(io.jsonwebtoken.JwtException.class, () ->
                jwtUtil.getUsernameFromToken(invalidToken));
    }

    /**
     * Prueba que arroja excepción al intentar obtener el rol de un token inválido.
     */
    @Test
    void getRoleFromToken_throwsForInvalidToken() {
        String invalidToken = "invalid.token.value";

        // Debe lanzar una excepción JwtException
        assertThrows(io.jsonwebtoken.JwtException.class, () ->
                jwtUtil.getRoleFromToken(invalidToken));
    }
}

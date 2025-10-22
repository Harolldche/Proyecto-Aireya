package com.aireya.aireya.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ProblemDetail;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Pruebas unitarias para GlobalExceptionHandler.
 * Se valida el comportamiento de los métodos que manejan excepciones globales.
 */
class GlobalExceptionHandlerTest {

    private GlobalExceptionHandler handler;
    private HttpServletRequest request;

    @BeforeEach
    void setUp() {
        // Inicializa el manejador y simula una solicitud HTTP
        handler = new GlobalExceptionHandler();
        request = mock(HttpServletRequest.class);
        when(request.getRequestURI()).thenReturn("/api/test");
    }

    @Test
    void handleNotFound_returnsNotFoundProblemDetail() {
        // Verifica que se retorne el detalle correcto cuando ocurre NotFoundException
        NotFoundException ex = new NotFoundException("No encontrado");
        ResponseEntity<ProblemDetail> response = handler.handleNotFound(ex, request);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Recurso no encontrado", response.getBody().getTitle());
        assertEquals("No encontrado", response.getBody().getDetail());
        assertEquals("/api/test", response.getBody().getProperties().get("path"));
    }

    @Test
    void handleValidation_returnsBadRequestWithErrors() {
        // Simula errores de validación de campos
        FieldError fieldError = new FieldError("obj", "nombre", "es requerido");
        BindingResult bindingResult = mock(BindingResult.class);
        when(bindingResult.getFieldErrors()).thenReturn(List.of(fieldError));

        MethodArgumentNotValidException ex =
                new MethodArgumentNotValidException(null, bindingResult);

        ResponseEntity<ProblemDetail> response = handler.handleValidation(ex, request);

        // Verifica que la respuesta sea BAD_REQUEST y contenga errores
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Datos inválidos", response.getBody().getTitle());
        assertTrue(response.getBody().getProperties().containsKey("errors"));
        assertEquals("/api/test", response.getBody().getProperties().get("path"));
    }

    @Test
    void handleRSE_returnsCustomStatusAndReason() {
        // Prueba que maneje correctamente excepciones con un estado personalizado
        ResponseStatusException ex =
                new ResponseStatusException(HttpStatus.FORBIDDEN, "No autorizado");
        ResponseEntity<ProblemDetail> response = handler.handleRSE(ex, request);

        assertEquals(HttpStatus.FORBIDDEN, response.getStatusCode());
        assertEquals("Error de aplicación", response.getBody().getTitle());
        assertEquals("No autorizado", response.getBody().getDetail());
        assertEquals("/api/test", response.getBody().getProperties().get("path"));
    }
}

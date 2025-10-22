package com.aireya.aireya.config;

// Importaciones necesarias para el test
import com.aireya.aireya.domain.model.User;
import com.aireya.aireya.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de prueba unitaria para la clase DataInitializer.
 * Esta clase valida que el proceso de inicialización de datos (usuarios por defecto, por ejemplo)
 * se realice correctamente al iniciar la aplicación.
 */
@ExtendWith(MockitoExtension.class) // Indica que se usará Mockito con JUnit 5
class DataInitializerTest {

    // Se crean mocks de las dependencias que utiliza DataInitializer
    @Mock UserRepository userRepository; // Mock del repositorio de usuarios
    @Mock PasswordEncoder passwordEncoder; // Mock del codificador de contraseñas

    /**
     * Prueba que verifica que se cree un usuario administrador ("admin")
     * cuando este no existe previamente en la base de datos.
     */
    @Test
    void initCreatesAdminWhenMissing() throws Exception {
        // Simula que el usuario "admin" no existe
        when(userRepository.existsByUsername("admin")).thenReturn(false);
        // Simula el comportamiento del codificador de contraseñas
        when(passwordEncoder.encode("admin123")).thenReturn("enc");

        // Crea una instancia del DataInitializer con los mocks inyectados
        DataInitializer di = new DataInitializer(userRepository, passwordEncoder);
        // Obtiene el CommandLineRunner (método que se ejecuta al iniciar la app)
        var runner = di.init();
        // Ejecuta el método run() que realiza la inicialización
        runner.run();

        // Verifica que se haya llamado al método save() del repositorio para guardar el admin
        verify(userRepository).save(any());
    }

    /**
     * Prueba que verifica que NO se cree un usuario administrador
     * cuando ya existe uno en la base de datos.
     */
    @Test
    void initDoesNotCreateWhenExists() throws Exception {
        // Simula que el usuario "admin" ya existe
        when(userRepository.existsByUsername("admin")).thenReturn(true);

        // Crea una instancia del DataInitializer
        DataInitializer di = new DataInitializer(userRepository, passwordEncoder);
        // Obtiene y ejecuta el CommandLineRunner
        var runner = di.init();
        runner.run();

        // Verifica que NUNCA se haya llamado al método save()
        verify(userRepository, never()).save(any());
    }

    /**
     * Prueba simple para cubrir la ejecución del constructor de DataInitializer,
     * asegurando que se puede instanciar sin errores.
     */
    @Test
    void constructorCovered() {
        new DataInitializer(userRepository, passwordEncoder);
    }
}

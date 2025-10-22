package com.aireya.aireya;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.boot.SpringApplication;

class AireYaApplicationMainTest {

    @Test
    void mainExecutesWithoutException() {
        // Mockear SpringApplication.run() para que no intente levantar Spring Boot
        try (MockedStatic<SpringApplication> mocked = Mockito.mockStatic(SpringApplication.class)) {
            mocked.when(() -> SpringApplication.run(AireYaApplication.class, new String[]{}))
                  .thenReturn(null); // no devuelve contexto real
            AireYaApplication.main(new String[]{});
        }
    }
}

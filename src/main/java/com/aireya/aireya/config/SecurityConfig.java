package com.aireya.aireya.config;

import com.aireya.aireya.security.JwtAuthenticationEntryPoint;
import com.aireya.aireya.security.JwtAuthenticationFilter;
import com.aireya.aireya.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfig {

    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return new ProviderManager(provider);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        JwtAuthenticationFilter jwtFilter = new JwtAuthenticationFilter(jwtUtil, userDetailsService);

        http
            .csrf(csrf -> csrf.disable())
            .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .exceptionHandling(ex -> ex.authenticationEntryPoint(new JwtAuthenticationEntryPoint()))
            .authorizeHttpRequests(auth -> auth
                // Endpoints públicos (auth y swagger)
                .requestMatchers("/api/v1/auth/**",
                                 "/swagger-ui/**",
                                 "/v3/api-docs/**",
                                 "/swagger-ui.html").permitAll()

                // Endpoints GET públicos
                .requestMatchers(HttpMethod.GET,
                        "/api/v1/stations/**",
                        "/api/v1/measurements/**",
                        "/api/v1/municipalities/**",
                        "/api/v1/departments/**",
                        "/api/v1/datasources/**"
                ).permitAll()

                // Endpoints restringidos a ADMIN (modificación de datos sensibles)
                .requestMatchers(HttpMethod.POST,
                        "/api/v1/stations/**",
                        "/api/v1/measurements/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT,
                        "/api/v1/stations/**",
                        "/api/v1/measurements/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE,
                        "/api/v1/stations/**",
                        "/api/v1/measurements/**").hasRole("ADMIN")

                // Cualquier otro endpoint requiere autenticación
                .anyRequest().authenticated()
            )
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}

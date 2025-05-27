package com.brettspiele.brettspieleapi.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/",                         // optional
                                "/index.html",              // optional
                                "/swagger-ui/**",           // Swagger UI
                                "/v3/api-docs/**",          // OpenAPI JSON
                                "/webjars/**",              // bei Swagger 2
                                "/swagger-resources/**",    // bei Swagger 2
                                "/configuration/**",        // bei Swagger 2
                                "/css/**", "/js/**",
                                "http://localhost:8081/swagger-ui/index.html")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                )
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(Customizer.withDefaults())
                );
        return http.build();
    }
}

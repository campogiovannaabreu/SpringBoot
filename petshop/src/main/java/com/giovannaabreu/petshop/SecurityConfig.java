package com.giovannaabreu.petshop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Desabilita CSRF para facilitar testes via Postman
            .cors(cors -> {})            // Ativa a configuração de CORS
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/categorias/**").permitAll() // Libera acesso para categorias
                .anyRequest().authenticated()                      // Exige login para o resto
            );
        
        return http.build();
    }

    // Bean para criptografia de senhas
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
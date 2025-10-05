package com.xzymon.maiordomus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Pozwala na CORS dla wszystkich endpointów
                        .allowedOrigins("*") // Zezwala na żądania ze wszystkich domen
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Pozwalane metody HTTP
                        .allowedHeaders("*"); // Zezwala na wszystkie nagłówki
            }
        };
    }
}
package com.portal.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // Apply to all endpoints under /api
            .allowedOrigins("http://localhost:4200") // Specify the allowed frontend URL
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allow necessary HTTP methods
            .allowedHeaders("*")
            .exposedHeaders("Authorization")
            .allowCredentials(true); // If you are using cookies/sessions
    }
}

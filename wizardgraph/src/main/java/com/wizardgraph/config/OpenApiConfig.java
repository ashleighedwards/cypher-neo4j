package com.wizardgraph.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Application OpenAPI / Swagger configuration.
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI wizardgraphOpenAPI() {
        return new OpenAPI()
            .components(new Components())
            .info(new Info()
                .title("Wizardgraph API")
                .version("0.0.1")
                .description("API for querying character relationships in Wizardgraph"));
    }
}

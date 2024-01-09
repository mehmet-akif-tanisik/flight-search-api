

package com.amadeus.flightsearchapi.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(name = "basicAuth", type = SecuritySchemeType.HTTP,
        scheme = "basic")
@OpenAPIDefinition(
        info = @Info(title = "FLIGHT SEARCH API CoderSpace x Amadeus", version = "v1", description = "The Flight Search API System is a backend API designed to manage flight and airport information\n" +
                "in a database. The data model includes entities for flights and airports, supporting CRUD\n" +
                "operations for consistent data management. Additionally, a Search API endpoint is implemented\n" +
                "to list flights based on specified criteria.In addition to the basic CRUD operations for flights and airports, a triggered job has been implemented to periodically\n" +
                "retrieve and update flight details from the external API. This ensures that the system remains up-to-date\n" +
                "with the latest flight information. This system enables users to create, read, update,\n" +
                "and delete flight and airport records, facilitating a comprehensive and organized approach to\n" +
                "flight booking and information retrieval."),
        security = @SecurityRequirement(name = "basicAuth")
)
public class OpenApiConfig {
}

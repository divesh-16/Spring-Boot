package com.tca.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Employee CRUD Management API",
        version = "v1.0.0",
        description = "This API handles performs CRUD operations on Employee data",
        contact = @Contact(
            name = "API Support Team",
            email = "support@example.com",
            url = "https://example.com"
        ),
        license = @License(
            name = "Apache 2.0",
            url = "https://apache.org"
        )
    ),
    servers = {
        @Server(
            description = "Local Development Server",
            url = "http://localhost:8081"
        ),
        @Server(
            description = "Staging Environment",
            url = "https://example.com"
        )
    }
)
public class OpenAPIConfig 
{
	
}

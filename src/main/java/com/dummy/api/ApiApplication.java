package com.dummy.api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
			contact = @Contact(
				name = "Cristiano Costa",
				email = "crisaodev@outlook.com",
				url = "https://www.linkedin.com/in/cristiano-costa-709469203/"
			),
			title = "Api Dummy - spec",
			description = "OpenApi documentation for API Dummy",
			version = "1.0",
			license = @License(
				name = "MIT License",
				url = "https://github.com/crisaoo/api-dummy/blob/main/LICENSE"
			)
		),
		servers = @Server(
				description = "Local ENV",
				url = "http://localhost:8080"
		)
)
public class ApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}

package com.application.dreamstuffapplicationapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@EntityScan("com.application.dreamstuffapplicationapi.models")
@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "DREAMSTUFF.IND APPLICATION API",
				version = "1.0.0",
				description = "This project is only for Learning!",
				termsOfService = "anton-alifandi",
				contact = @Contact(
						name = "Anton Alifandi",
						email = "alifandianton20@gmail.com"
				),
				license = @License(
						name = "licence",
						url = "anton-alifandi"
				)
		)
)

public class DreamstuffApplicationApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DreamstuffApplicationApiApplication.class, args);
	}

}

package com.shashwat.crickscores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
		info = @Info(
				contact = @Contact(
						name = "Shashwat Pandey (Github)",
						email = "2001shashwat.rdr@gmail.com",
						url = "https://github.com/shashwat9470"
					),
				title = "CrickScores api",
				description = "This api is for the backend web-scraper application (built using Spring Boot and Jsoup) for getting cricket related information in JSON fromat, which can be further be used by suitable frontend client.",
				version = "1.0"
			)
		)
@SpringBootApplication
public class CrickScoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrickScoresApplication.class, args);
	}

}

package com.swag.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class SwagOfflineDocumentationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwagOfflineDocumentationApplication.class, args);
	}
}

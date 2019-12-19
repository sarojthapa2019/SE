package edu.mum.cs.cs425.elibrary2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Elibrary2Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Elibrary2Application.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Elibrary2Application.class);
	}

}

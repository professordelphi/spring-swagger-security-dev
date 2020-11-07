package com.sb.estudo.sbestudo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Controller;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@Controller
@ComponentScan({ "com.sb.estudo.sbestudo.*" })
@EnableSwagger2
@EnableWebSecurity
public class SbestudoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbestudoApplication.class, args);
	}
	
	}

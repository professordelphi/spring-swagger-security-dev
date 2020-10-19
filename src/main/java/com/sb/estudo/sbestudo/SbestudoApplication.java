package com.sb.estudo.sbestudo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
	
	@GetMapping("/")
	public String teste() {
		return "index";
	}

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
}
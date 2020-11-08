package com.sb.estudo.sbestudo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@Controller
@ComponentScan({ "com.sb.estudo.sbestudo.*" })
@EnableSwagger2
//@EnableWebSecurity provocar merge
public class SbestudoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbestudoApplication.class, args);
	}
	
	
}

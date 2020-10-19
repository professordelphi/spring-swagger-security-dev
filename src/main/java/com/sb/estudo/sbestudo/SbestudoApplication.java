package com.sb.estudo.sbestudo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan({ "com.sb.estudo.sbestudo.*" })
@EnableSwagger2
public class SbestudoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbestudoApplication.class, args);
	}

}

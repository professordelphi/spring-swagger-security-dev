package com.sb.estudo.sbestudo.utils;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ValuesClass {

	
	@Value("${spring.security.user.name}")
	private String usuario;
	
	
	@PostConstruct
	public void print()
	{
		
		System.out.println("usario" + usuario);
	}
	
}

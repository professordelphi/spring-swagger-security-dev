package com.sb.estudo.sbestudo.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import com.sb.estudo.sbestudo.entity.Funcionario;
import com.sb.estudo.sbestudo.repository.FuncionarioRepository;
import com.sb.estudo.sbestudo.service.FuncionarioService;
import com.sb.estudo.sbestudo.serviceImp.FuncionarioServiceImp;

import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;

@WebMvcTest
public class FuncionarioControllerTestAW {

	

	@MockBean
	private FuncionarioServiceImp funcionarioService;
	
	
	List<Funcionario> listaFuncionario = null;
	
	@Autowired
	private FuncionarioController funcionarioController;

	@BeforeEach
	public void setup() {
		RestAssuredMockMvc.standaloneSetup(this.funcionarioController);

	
	}

	@Test
	public void getAllTest() throws Exception {

		
		 listaFuncionario = new ArrayList<Funcionario>();
			Funcionario funcionarioEsperado = new Funcionario();
			funcionarioEsperado.setId((long) 1);
			funcionarioEsperado.setNome("Marcos");
			funcionarioEsperado.setCpf("12345678912");
			funcionarioEsperado.setEndereco("Barra");
	//		listaFuncionario.add(funcionarioEsperado);
	
		Funcionario f =	this.funcionarioService.salvar(funcionarioEsperado);
			listaFuncionario.add(f);
			
			
		when(this.funcionarioService.findAll()).thenReturn(listaFuncionario);
		RestAssuredMockMvc
		.given()
		.accept(ContentType.JSON)
		.when()
		.get()
		.then()
		.statusCode(HttpStatus.NO_CONTENT.value());

	}

}

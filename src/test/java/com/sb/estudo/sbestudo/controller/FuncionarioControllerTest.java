package com.sb.estudo.sbestudo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.sb.estudo.sbestudo.entity.Funcionario;
import com.sb.estudo.sbestudo.service.FuncionarioService;


import io.restassured.module.mockmvc.RestAssuredMockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers=FuncionarioController.class)
//@WebMvcTest
public class FuncionarioControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private FuncionarioService funcionarioService;

	
	
	private Funcionario funcionarioEsperado;
	
	@Autowired
	private FuncionarioController funcionarioController;
	
	
	@BeforeEach
	public void setup()
	{
		RestAssuredMockMvc.standaloneSetup(this.funcionarioController);
funcionarioEsperado  = new Funcionario();
funcionarioEsperado.setId((long) 1);
funcionarioEsperado.setNome("Marcos");
funcionarioEsperado.setCpf("12345678912");
funcionarioEsperado.setEndereco("Barra");
		
	}
	
	
	@Test 
	public void testarHello() throws Exception
	{
		
		mockMvc.perform(MockMvcRequestBuilders.get("/hellotest"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("Hello"));
	}
	
	
	@Test 
	public void salvarTest() throws Exception
	{
		
		funcionarioEsperado  = new Funcionario();
		funcionarioEsperado.setId((long) 1);
		funcionarioEsperado.setNome("Marcos");
		funcionarioEsperado.setCpf("12345678912");
		funcionarioEsperado.setEndereco("Barra");

		when(this.funcionarioService.salvar(funcionarioEsperado)).thenReturn(funcionarioEsperado);

		Funcionario funcionarioEsperado2  = new Funcionario();
		funcionarioEsperado2.setId((long) 1);
		funcionarioEsperado2.setNome("Marcos");
		funcionarioEsperado2.setCpf("12345678912");
		funcionarioEsperado2.setEndereco("Barra");



		mockMvc.perform(MockMvcRequestBuilders.post("/"))
	//	.contentType(MediaType.APPLICATION_JSON_UTF8)
//		.accept(MediaType.APPLICATION_JSON_UTF8)
//		.content(JsonUtils.toJson(funcionarioEsperado2)))
		.andExpect(status().isOk());
	//	.andExpect(content().json(JSonUtils.toJson(funcionarioEsperado)));




		
	}
	
	
}

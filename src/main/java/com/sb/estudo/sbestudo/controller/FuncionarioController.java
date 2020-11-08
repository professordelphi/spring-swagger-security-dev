package com.sb.estudo.sbestudo.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sb.estudo.sbestudo.entity.Funcionario;
import com.sb.estudo.sbestudo.except.ExceptFuncionario;
import com.sb.estudo.sbestudo.service.FuncionarioService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1")
public class FuncionarioController {

	@Autowired(required = true)
	FuncionarioService funcionarioService;


	@ApiOperation(value = "Retorna uma lista de pessoas")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Retorna a lista de pessoa"),
	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@GetMapping("{id}")
	public ResponseEntity<Funcionario> getOne(@PathVariable  long id) throws ExceptFuncionario {
		Funcionario funcionario = this.funcionarioService.getOne(id).get();

		if (funcionario.equals(null))
			throw new ExceptFuncionario("Funcionario nao encontrado");

		return ResponseEntity.ok(funcionario);
	}

	@GetMapping("/url/{id}")
	public ResponseEntity<Optional<Funcionario>> urlHateoas(@PathVariable("id") long id) {
		Optional<Funcionario> funcionario = this.funcionarioService.getOne(id);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("").buildAndExpand(funcionario.get())
				.toUri();

		return ResponseEntity.created(location).build();

	}
	
	
	@PostMapping
	public Funcionario salvar( Funcionario funcionarioRequest)
	{
		
		System.out.print("passei aqui" + funcionarioRequest.getNome());
		
		return this.funcionarioService.salvar(funcionarioRequest);
		
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("").buildAndExpand(funcionario.get())
		//		.toUri();

	//	return ResponseEntity.created(location).build();

	}
	
	@GetMapping
	public ResponseEntity<List<Funcionario>> getAllFunc() throws ExceptFuncionario {
		List<Funcionario> funcionario = this.funcionarioService.findAll();

		if (funcionario.equals(null))
			throw new ExceptFuncionario("Funcionario nao encontrado");

		return ResponseEntity.ok(funcionario);
	}
	
	@GetMapping("/rest")
	public void getForObject() {
		// request url
		String url = "https://jsonplaceholder.typicode.com/posts/1";

		// create an instance of RestTemplate
		RestTemplate restTemplate = new RestTemplate();

		// make an HTTP GET request
	//	String json = restTemplate.getForObject(url, String.class);

		String json = restTemplate.getForObject(url, String.class);
		// print json
		System.out.println(json);
		}

	
	@GetMapping("/hellotest")
	public String testarHello()
	{
		return "Hello";
		
	}
}

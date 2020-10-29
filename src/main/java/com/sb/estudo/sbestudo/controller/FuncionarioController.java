package com.sb.estudo.sbestudo.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

	@Autowired
	FuncionarioService funcionarioService;


	@ApiOperation(value = "Retorna uma  pessoa")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Retorna a lista de pessoa"),
	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> getOne(@PathVariable long id) throws ExceptFuncionario {
	Optional<Funcionario> funcionario = this.funcionarioService.getOne(id);

		if (!funcionario.isPresent())
			throw new ExceptFuncionario("Funcionario nao encontrado");

		return ResponseEntity.ok(funcionario.get());
	}

	@GetMapping("/url/{id}")
	public ResponseEntity<Optional<Funcionario>> urlHateoas(@PathVariable long id) {
		Optional<Funcionario> funcionario = this.funcionarioService.getOne(id);

		if (!funcionario.isPresent())
		{
					return new ResponseEntity<Optional<Funcionario>>(funcionario, HttpStatus.NO_CONTENT);
			
				}
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("").buildAndExpand(funcionario.get())
				.toUri();

		return ResponseEntity.created(location).build();
 
		
	}
	
	
	@PostMapping
	public ResponseEntity<Funcionario> salvar( Funcionario funcionarioRequest)
	{
		
	//	System.out.print("passei aqui" + funcionarioRequest.getNome());
		
	Funcionario func = this.funcionarioService.salvar(funcionarioRequest);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("").buildAndExpand(func)
				.toUri();

		return ResponseEntity.created(location).build();

	}
	

	
	@DeleteMapping
	public void deletar( Funcionario funcionarioRequest)
	{
		
	//	System.out.print("passei aqui" + funcionarioRequest.getNome());
		
	this.funcionarioService.delete(funcionarioRequest);
		
	//	URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("").buildAndExpand(func)
		//		.toUri();

	//	return ResponseEntity.created(location).build();
	
	

	}


}

package com.sb.estudo.sbestudo.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sb.estudo.sbestudo.entity.Funcionario;
import com.sb.estudo.sbestudo.except.ExceptFuncionario;
import com.sb.estudo.sbestudo.serviceImp.FuncionarioServiceImp;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1")
public class FuncionarioController {

	@Autowired
	FuncionarioServiceImp funcionarioService;

	
	@ApiOperation(value = "Retorna uma lista de pessoas")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Retorna a lista de pessoa"),
	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@GetMapping(value = "{id}", produces="application/json")
	public ResponseEntity<Funcionario> getOne(@PathVariable long id) throws ExceptFuncionario {
		Funcionario funcionario = this.funcionarioService.getOne(id).get();

		if (funcionario.equals(null))
			throw new ExceptFuncionario("Funcionario nao encontrado");

		return ResponseEntity.ok(funcionario);
	}

	@GetMapping("/url/{id}")
	public ResponseEntity<Optional<Funcionario>> urlHateoas(@PathVariable long id) {
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

}

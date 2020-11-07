package com.sb.estudo.sbestudo.service;

import java.util.List;
import java.util.Optional;

import com.sb.estudo.sbestudo.entity.Funcionario;


public interface FuncionarioService {
	
	
	public Optional<Funcionario> getOne(long id);
	public Funcionario salvar(Funcionario funcionarioRequest);
	public List<Funcionario> findAll();
	
}

package com.sb.estudo.sbestudo.serviceImp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.estudo.sbestudo.entity.Funcionario;
import com.sb.estudo.sbestudo.repository.FuncionarioRepository;
import com.sb.estudo.sbestudo.service.FuncionarioService;

@Service
public class FuncionarioServiceImp implements FuncionarioService {

	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	@Override
	public Optional<Funcionario> getOne(long id) {
		// TODO Auto-generated method stub
		
			
		return	this.funcionarioRepository.findById(id);
		 
	}

	public Funcionario salvar(Funcionario funcionarioRequest) {
		// TODO Auto-generated method stub
		
		//Funcionario func = new Funcionario();
	//	func.setNome(funcionarioRequest.getNome());
		
		return this.funcionarioRepository.save(funcionarioRequest);
		
		
	}
	
	
	

}

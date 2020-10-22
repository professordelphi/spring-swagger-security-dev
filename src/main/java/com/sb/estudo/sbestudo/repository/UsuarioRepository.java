package com.sb.estudo.sbestudo.repository;

import org.springframework.data.repository.CrudRepository;

import com.sb.estudo.sbestudo.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String>{

	Usuario findByLogin(String login);
}

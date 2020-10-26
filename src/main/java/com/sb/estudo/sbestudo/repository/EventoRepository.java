package com.sb.estudo.sbestudo.repository;

import org.springframework.data.repository.CrudRepository;

import com.sb.estudo.sbestudo.entity.Evento;

public interface EventoRepository extends CrudRepository<Evento, String>{
	Evento findByCodigo(long codigo);
}

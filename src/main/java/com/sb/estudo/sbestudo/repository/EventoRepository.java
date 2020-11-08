package com.sb.estudo.sbestudo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sb.estudo.sbestudo.entity.Evento;

@Repository
public interface EventoRepository extends CrudRepository<Evento, String>{
	Evento findByCodigo(long codigo);
}

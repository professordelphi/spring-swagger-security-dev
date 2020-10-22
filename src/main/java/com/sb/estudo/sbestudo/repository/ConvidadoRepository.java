package com.sb.estudo.sbestudo.repository;

import org.springframework.data.repository.CrudRepository;

import com.sb.estudo.sbestudo.entity.Convidado;
import com.sb.estudo.sbestudo.entity.Evento;

public interface ConvidadoRepository extends CrudRepository<Convidado, String>{
	Iterable<Convidado> findByEvento(Evento evento);
	Convidado findByRg(String rg);
}

package com.sb.estudo.sbestudo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sb.estudo.sbestudo.entity.Convidado;
import com.sb.estudo.sbestudo.entity.Evento;

@Repository
public interface ConvidadoRepository extends CrudRepository<Convidado, String>{
	Iterable<Convidado> findByEvento(Evento evento);
	Convidado findByRg(String rg);
}

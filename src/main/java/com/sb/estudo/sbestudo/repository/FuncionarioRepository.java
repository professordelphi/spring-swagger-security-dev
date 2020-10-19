package com.sb.estudo.sbestudo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sb.estudo.sbestudo.entity.Funcionario;


@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

}

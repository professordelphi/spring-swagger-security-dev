package com.sb.estudo.sbestudo.controller;

import java.net.URI;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sb.estudo.sbestudo.entity.Funcionario;

@RestController
public class RestExampController {

    private static final Logger log = LoggerFactory.getLogger(RestExampController.class);

   
    RestTemplate restTemplate=new RestTemplate();

    @RequestMapping(value = "/testado")
    public ResponseEntity<Optional<Funcionario>> teste() {

        for (int i = 0; i < 100; i++) {

          Funcionario funcionario = restTemplate.getForObject("http://localhost:8082/api/v1/7", Funcionario.class);
            
          if (!funcionario.equals(null))
          {
          log.info("Resultado da Chamada RestExampĺeController:    "  + funcionario.toString());
          
      	URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("").buildAndExpand(funcionario)
				.toUri();

		return ResponseEntity.created(location).build();
          
          }
          else
          {log.error("Nenhum valor encontrado");}

        }
		return null;
    }
}
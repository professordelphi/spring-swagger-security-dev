package com.sb.estudo.sbestudo.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;


public class HomeControllerTest {

	@InjectMocks
	public HomeController home;

	@Mock
	File file;

	@Test
	public void moveFileOriginToDestinyTest() throws IOException {

		home = new HomeController();
		file = new File("C:\\temp\\spring-swagger-security-dev\\pravaler.txt");

		home.setFile(file.getName());
		home.setDestino("c:\\temp");
		
		   String protocolo="c:";

		    
		      String endereco="/temp";

		   
		     String porta="/sbestudo";

		
		StringBuilder url = new StringBuilder();
		url.append(protocolo).append(endereco).append(porta);
		

		Boolean retornado = this.home.moveFileOriginToDestiny(file.getName(), this.home.getDestino());

		// when(this.home.getFile()).thenReturn("C:\\temp\\spring-swagger-security-dev\\pravaler.txt");

		
		assertNotNull(home.getFile());
		assertNotNull(home.getDestino());
		assertEquals("c:\\temp", home.getDestino());
		
		assertEquals("c:/temp/sbestudo", url.toString());
		
		assertEquals(false, retornado);
		assertFalse(retornado);
	}

	/*
	 * public Boolean moveFileOriginToDestiny(String file, String destino) {
	 * 
	 * this.file = file; this.destino = destino;  ok
	 * 
	 * Boolean retornado=false;
	 * 
	 * StringBuilder url = new StringBuilder();
	 * url.append(protocolo).append(endereco).append(porta);  ok
	 * 
	 * // Arquivo a ser movido File arquivo = new
	 * File(url.append(this.file).toString()); // File arquivo = new
	 * File("C:\\temp\\sbestudo\\pravaler.txt");
	 * 
	 * logger.info(arquivo.getPath());
	 * 
	 * if (!arquivo.exists()) { logger.info("Arquivo não encontrado"); } else {
	 * 
	 * // Diretorio de destino File diretorioDestino = new File(this.destino);
	 * 
	 * // Move o arquivo para o novo diretorio boolean sucesso =
	 * arquivo.renameTo(new File(diretorioDestino, arquivo.getName())); if (sucesso)
	 * { logger.info("Arquivo movido para '" + diretorioDestino.getAbsolutePath() +
	 * "'");
	 * 
	 * return retornado;
	 * 
	 * } else { logger.info("Erro ao mover arquivo '" + arquivo.getAbsolutePath() +
	 * "' para '" + diretorioDestino.getAbsolutePath() + "'");
	 * 
	 * } } return retornado; }
	 * 
	 */
}
//criar get´s  no MoveFile class
//criar o teste MoveFileTest
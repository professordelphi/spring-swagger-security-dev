package com.sb.estudo.sbestudo.controller;

import java.io.File;

import org.springframework.stereotype.Component;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component  
public class HomeController {  
         
    private static String protocolo="c:";

    
    private static String endereco="/temp";

   
    private static String porta="/sbestudo";

   private String file;
   private String destino;

	

    public static void main(String[] args) {
    	
  // 	 moveFileOriginToDestiny("/pravaler.txt","/temp");
   }

    
	public  Boolean moveFileOriginToDestiny(String file, String destino) {
	
		this.file = file;
		this.destino = destino;

		Boolean retornado=false;
		
		StringBuilder url = new StringBuilder();
        url.append(protocolo).append(endereco).append(porta);

	     // Arquivo a ser movido
			   File arquivo = new File(url.append(this.file).toString());
			   //	File arquivo = new File("C:\\temp\\sbestudo\\pravaler.txt");

		log.info(arquivo.getPath());
		   
		   if (!arquivo.exists()) {
			   log.info("Arquivo não encontrado");
		   } else {

		       // Diretorio de destino
		       File diretorioDestino = new File(this.destino);

		       // Move o arquivo para o novo diretorio
		       boolean sucesso = arquivo.renameTo(new File(diretorioDestino, arquivo.getName()));
		       if (sucesso) {
		    	   log.info("Arquivo movido para '" + diretorioDestino.getAbsolutePath() + "'");
		    	   
		    	   return retornado;
		    	   
		       } else {
		    	   log.info("Erro ao mover arquivo '" + arquivo.getAbsolutePath() + "' para '"
		                   + diretorioDestino.getAbsolutePath() + "'");
		    	   
		       }
		   }
		return retornado;
	}


	public String getFile() {
		return file;
	}


	public void setFile(String file) {
		this.file = file;
	}


	public String getDestino() {
		return destino;
	}


	public void setDestino(String destino) {
		this.destino = destino;
	}




	
}
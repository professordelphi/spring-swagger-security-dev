package com.sb.estudo.sbestudo.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import jdk.internal.org.jline.utils.Log;
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

		Log.info(arquivo.getPath());
		   
		   if (!arquivo.exists()) {
			   Log.info("Arquivo não encontrado");
		   } else {

		       // Diretorio de destino
		       File diretorioDestino = new File(this.destino);

		       // Move o arquivo para o novo diretorio
		       boolean sucesso = arquivo.renameTo(new File(diretorioDestino, arquivo.getName()));
		       if (sucesso) {
		    	   Log.info("Arquivo movido para '" + diretorioDestino.getAbsolutePath() + "'");
		    	   
		    	   return retornado;
		    	   
		       } else {
		    	   Log.info("Erro ao mover arquivo '" + arquivo.getAbsolutePath() + "' para '"
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
package com.sb.estudo.sbestudo.controller;








import java.io.File;

import org.springframework.stereotype.Component;




@Component  
public class HomeController {  
         
	
	public HomeController() {
		// TODO Auto-generated constructor stub
	}
	
	private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger("Prav");
    private  String protocolo="c:";

    
    private  String endereco="/temp";

   
    private   String porta="/sbestudo/";

  
	

  
    
	public  Boolean moveFileOriginToDestiny(String file, String destino) {
	
	
		Boolean retornado=false;
		
		StringBuilder url = new StringBuilder();
        url.append(protocolo).append(endereco).append(porta);

	     // Arquivo a ser movido
			   File arquivo = new File(url.append(file).toString());
			   //	File arquivo = new File("C:\\temp\\sbestudo\\pravaler.txt");

		logger.info(arquivo.getPath());
		   
		   if (!arquivo.exists() || file.equals("") ) {
			   logger.info("Arquivo não encontrado");
			   return false;
		   } else {

		       // Diretorio de destino
		       File diretorioDestino = new File(destino);
Boolean sucesso = arquivo.renameTo(new File(diretorioDestino, arquivo.getName()));
		      if (sucesso )  {
		    	 // Move o arquivo para o novo diretorio
		    	   
		    	   logger.info("Arquivo movido para '" + diretorioDestino.getAbsolutePath() + "'");
		    	   
		    	   return retornado=true;
		    	   
		       } else {
		    	   logger.info("Erro ao mover arquivo '" + arquivo.getAbsolutePath() + "' para '"
		                   + diretorioDestino.getAbsolutePath() + "'");
		    	   
		       }
		   }
		return retornado;
	}


	



	
}
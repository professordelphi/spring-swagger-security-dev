package com.sb.estudo.sbestudo.controller;








import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;




@Controller
public class IndexController2 {  
         
	
	/*
	 * @RequestMapping("/test") public ModelAndView teste(){
	 * 
	 * return new ModelAndView("teste");
	 * 
	 * }
	 */
	
	
	
		@RequestMapping(value="/login",method=RequestMethod.GET)
		public String busca(){
			return "redirecionado";
		}
	
	
	@RequestMapping(value="/cad",method=RequestMethod.GET)
	public String teste(){
		return "index";
	}
	
	@RequestMapping(value="/cadastrar", method=RequestMethod.GET)
	public String form(RedirectAttributes attributes,BindingResult result){
		
		if(result.hasErrors()){
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
		}
		return "teste";
	}
	
	public IndexController2() {
		// TODO Auto-generated constructor stub
	}
	
	private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger("Prav");
    private  String protocolo="c:";

    
    private  String endereco="/temp";

   
    private  String porta="/sbestudo/";

   private String file;
   private String destino;

	

  
    
	public  Boolean moveFileOriginToDestiny(String file, String destino) {
	
		this.file = file;
		this.destino = destino;

		Boolean retornado=false;
		
		StringBuilder url = new StringBuilder();
        url.append(protocolo).append(endereco).append(porta);

	     // Arquivo a ser movido
			   File arquivo = new File(url.append(this.file).toString());
			   //	File arquivo = new File("C:\\temp\\sbestudo\\pravaler.txt");

		logger.info(arquivo.getPath());
		   
		   if (!arquivo.exists()) {
			   logger.info("Arquivo não encontrado");
		   } else {

		       // Diretorio de destino
		       File diretorioDestino = new File(this.destino);

		       // Move o arquivo para o novo diretorio
		       boolean sucesso = arquivo.renameTo(new File(diretorioDestino, arquivo.getName()));
		       if (sucesso) {
		    	   logger.info("Arquivo movido para '" + diretorioDestino.getAbsolutePath() + "'");
		    	   
		    	   return retornado=true;
		    	   
		       } else {
		    	   logger.info("Erro ao mover arquivo '" + arquivo.getAbsolutePath() + "' para '"
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
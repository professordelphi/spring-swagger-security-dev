package com.sb.estudo.sbestudo.serviceimp;






import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*starter web
 * devtools
 * starter test
 * <excluisons>	<dependency>
	    <groupId>org.junit.vintage</groupId>
	    <artifactId>junit-vintage-engine</artifactId>
	 	    <scope>test</scope>
	</dependency>
 * 
 * <exclusion>
 * 
 * <groupId>org.junit.vintage</groupId>
 * <artifactId>junit-vintage-engine</artifactId>
 * 
 * 
 * 
 * <!-- 	<dependency>
	    <groupId>org.junit.vintage</groupId>
	    <artifactId>junit-vintage-engine</artifactId>
	 	    <scope>test</scope>
	</dependency> -->
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sb.estudo.sbestudo.controller.FuncionarioController;
import com.sb.estudo.sbestudo.entity.Funcionario;
import com.sb.estudo.sbestudo.repository.FuncionarioRepository;
import com.sb.estudo.sbestudo.serviceImp.FuncionarioServiceImp;

import io.restassured.http.ContentType;


//@RunWith(SpringRunner.class)
//@DataJpaTest
@WebMvcTest
public class FuncionarioServiceImpTest {
	
	//@Autowired
	//FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private FuncionarioController funcionarioController;
	
	@MockBean
	private FuncionarioServiceImp funcionarioServiceImp;

	@MockBean
	private FuncionarioRepository funcionarioRepository;
	

	@BeforeEach
	public void setup()
	{
	standaloneSetup(this.funcionarioController);
		
}
	
	
	
	@Test
	public void funcionario_findByOne() throws Exception
	{
		Funcionario funcionario=new Funcionario(1L,"Marcos", "12345678981", "Rua x");
		when(this.funcionarioServiceImp.getOne(1L)).thenReturn(Optional.of(funcionario));
		 Funcionario funcionarioSalvo = 		this.funcionarioServiceImp.salvar(funcionario);
	     assertThat(funcionario.getNome()).isEqualTo("Marcos");
		this.funcionarioRepository.findById(funcionario.getId());
		assertThat(funcionarioRepository.findById(funcionario.getId()));

	given()
	.accept(ContentType.JSON)
	.when()
	.get("http://localhost:8082/api/v1/{id}",1L)
	.then()
	.statusCode(HttpStatus.SC_OK);
	
	}

}

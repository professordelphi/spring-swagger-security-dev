package com.sb.estudo.sbestudo.dto;

import java.util.List;
import java.util.stream.Stream;

import javax.validation.constraints.NotEmpty;

import com.sb.estudo.sbestudo.entity.Funcionario;




public class FuncionarioRequestDto {

	@NotEmpty
	private String nome;

	public FuncionarioRequestDto(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FuncionarioRequestDto other = (FuncionarioRequestDto) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FuncionarioRequestDto [nome=" + nome + "]";
	}
	
	
	public static void main(String[] args) {

		 // Creating a Stream of Strings 
        Stream<String> stream = Stream.of("GReks", "fOr", 
                                          "GEEKSQUIZ", "GeeksforGeeks"); 
  
        // Using Stream filter(Predicate predicate) 
        // to get a stream consisting of the 
        // elements having UpperCase Character 
        // at index 1 
        stream.filter(str -> Character.isUpperCase(str.charAt(1))) 
            .forEach(System.out::println); 
    }

    private static Funcionario getStudentByName(List<Funcionario> funcionarios, String name) {

        Funcionario result = null;
        for (Funcionario temp : funcionarios) {
            if (name.equals(temp.getNome())) {
                result = temp;
            }
        }
        return result;
    }




}

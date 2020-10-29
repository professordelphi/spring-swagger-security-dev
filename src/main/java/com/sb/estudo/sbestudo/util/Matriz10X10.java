package com.sb.estudo.sbestudo.util;

import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Matriz10X10 {

	public static void main(String[] args) {
		
		
System.out.println(	fatorialRecursivo(5));
	}
	
	 public static int fatorialRecursivo(int num) {

	        /**
	         * Este é o caso base, se o número passado por parametro for 0 ou 1,
	         * ele retorna o resultado 1 e finaliza o método.
	         */
	        if (num <= 1) {

	            return 1;

	        } else {

	            /**
	             * chama o método fatorial novamente, mas dessa vez enviando como
	             * parametro (n - 1).
	             */
	            
	            return fatorialRecursivo(num - 1) * num;

	        }

	    }
	  
	
}

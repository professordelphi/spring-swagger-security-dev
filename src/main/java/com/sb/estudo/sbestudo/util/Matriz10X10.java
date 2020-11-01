package com.sb.estudo.sbestudo.util;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Matriz10X10 {

	public static void main(String[] args) {
		
		int[] nums = {2,7,3,15,4,5,8,6};
		int soma=0;		
		
//System.out.println(	fatorialRecursivo(5));

soma2Numeros(nums, soma);


	}
	
	 public static int fatorialRecursivo(int num) {
		  Scanner scanei =new Scanner(System.in);
		  int recebe =0;
		 try {
			  recebe = scanei.nextInt();
			  System.out.println(recebe);
		}
		 catch (NoSuchElementException e) {
			// TODO: handle exception
		}
		 finally { 
			
			scanei.close();
			// TODO: handle finally clause
		}
		 
		
		 
		
		 
		
		
		 
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
	  
	 
/*	 nums[] = {2,7,11,15};
	  
	  nums[0]=2;
	  nums[1]=7;
	  nums[2]=11;
	  nums[3]=15;
*/
	 	 
		 public static int[] soma2Numeros(int[] nums, int soma)
		 {
soma =0;
			  
			  for (int i = 0; i < nums.length; i++) {
				
					  {
				  if (nums[i]<9)
					  
				  {
					  
				  soma = soma+ nums[i];
				  
				  if (soma==9) 
				  {
				  
				  System.out.println(nums[i-1]+" "+nums[i]);
				  i++;
				  soma=0;
				  
				//  soma2Numeros(nums, soma);
				  
				  }
				  
				  }
				  
			  }

		 
			
		 


		 
		 
		 }
			  return nums;
		 
		 }
}
	


package com.c4rvmath.core;
import java.util.Scanner;
public class MathUtils {
	
	private static final Scanner entrada = new Scanner(System.in); //Único Scanner interno compartilhado pela biblioteca
	//Construtor privado para evitar que usem "new MathUtils()" sem necessidade
	private MathUtils() {
		//Impedimento de instanciação
	}
	//Método estático para somar
	public static double somar(double a, double b) {
		return a + b;
	}
	//Método estático para subtrair
	public static double subtrair(double a, double b) {
		return a - b;
	}
	//  ===Método de entrada personalizada===
	/*  
	 * 	Exibe mensagem personalizada do usuário e captura o número digitado
	 * ==============
	 */ 
	 public static double lerNumero(String mensagem) {
		 System.out.println(mensagem);
		 return entrada.nextDouble();
	 }
	
	 /*
	  * ==============
	  * Exibe mensagem personalizada do usuário e captura o operador digitado
	  * ==============
	  */
	 public static String lerOperador(String mensagem) {
		 System.out.println(mensagem);
		 return entrada.next();
	 }
	
	/*
	 * Motor de cálculo direto, recebe os parâmetros limpos e processa o resultado instantaneamente.
	 */
	public static double calcular(double valor1, String operador, double valor2) {
		// .trim() evita travamentos se o usuário digitar espaços acidentais
		switch(operador.trim()) {
		case "+":
			return somar(valor1, valor2);
		case "-":
			return subtrair(valor1, valor2);
		default:
			//Abordagem aplicada para bibliotecas, lança um erro claro em vez de apenas printar
			throw new IllegalArgumentException("Erro: O operador '" + operador + "' não é suportado. Aguarde futuras atualizações");
		}
	}
}

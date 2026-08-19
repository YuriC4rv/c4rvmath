package com.c4rvmath.core;
import java.util.Scanner;
public class MathUtils {
	
	private static final Scanner entrada = new Scanner(System.in); //Único Scanner interno compartilhado pela biblioteca
	//Construtor privado para evitar que usem "new MathUtils()" sem necessidade
	private MathUtils() {
		//Impedimento de instanciação
	
	/*
	 * =======
	 * Método de cálculos:
	 * =======
	 */
	
	}
	//Método para somar
	public static double somar(double a, double b) {
		return a + b;
	}
	//Método para subtrair
	public static double subtrair(double a, double b) {
		return a - b;
	}
	//Método para multiplicação
	public static double multiplicar(double a, double b) {
		return a * b;
	}
	//Método para divisão
	public static double dividir(double a, double b) {
		if(b == 0) {
			throw new ArithmeticException("Erro: divisão por zero não é permitida");
		}
		return a/b;
	}
	//Método para resto da divisão
	public static double resto(double a, double b) {
		if(b == 0) {
			throw new ArithmeticException("Erro: não é possível calcular o resto de uma divisão por zero!");
		}
		return a % b;
	}
	//Método para potência
	public static double potenciar(double base, double expoente) {
		return Math.pow(base, expoente);
	}
	//Método para raiz quadrada
	public static double radiciar(double numero) {
		if(numero < 0) {
			throw new ArithmeticException("Erro: não é possível calcular a raiz quadrada de um número negativo!");
		}
		return Math.sqrt(numero);
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
		case "*":
			return multiplicar(valor1, valor2);
		case "/":
			return dividir(valor1, valor2);
		case "%":
			return resto(valor1, valor2);
		case "^":
			return potenciar(valor1, valor2);
		case "v":
			return radiciar(valor1);
		//case
		default:
			//Abordagem aplicada para bibliotecas, lança um erro claro em vez de apenas printar
			throw new IllegalArgumentException("Erro: O operador '" + operador + "' não é suportado. Aguarde futuras atualizações");
		}
	}
	public static void exibirManual() {
			System.out.println("=== MANUAL DA BIBLIOTECA C4RVMATH ===");
			System.out.println("Como usar o metodo calcular(valor1, operador, valor2):");
			System.out.println("");
			System.out.println(" + : Soma o valor1 com o valor2");
			System.out.println(" - : Subtrai o valor2 do valor1");
			System.out.println(" * : Multiplica o valor1 pelo valor2");
			System.out.println(" / : Divide o valor1 pelo valor2 (Gera erro se valor2 for 0)");
			System.out.println(" % : Calcula o resto da divisao de valor1 por valor2");
			System.out.println(" ^ : Eleva o valor1 a potencia do valor2");
			System.out.println(" v : Calcula a raiz quadrada do valor1 (O valor2 e ignorado)");
			System.out.println("======================================");
	}
}

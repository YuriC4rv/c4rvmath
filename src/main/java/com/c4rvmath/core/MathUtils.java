package com.c4rvmath.core;

public final class MathUtils {

	private MathUtils() {
		// Impede a instanciação da classe
	}

	// Operações matemáticas básicas

	public static double somar(double a, double b) {
		return a + b;
	}

	public static double subtrair(double a, double b) {
		return a - b;
	}

	public static double multiplicar(double a, double b) {
		return a * b;
	}

	public static double dividir(double a, double b) {

		if (b == 0) {
			throw new ArithmeticException("Erro: divisão por zero não é permitida.");
		}

		return a / b;
	}

	public static double resto(double a, double b) {

		if (b == 0) {
			throw new ArithmeticException("Erro: não é possível calcular o resto de uma divisão por zero.");
		}

		return a % b;
	}

	public static double potenciar(double base, double expoente) {
		return Math.pow(base, expoente);
	}

	public static double radiciar(double numero) {

		if (numero < 0) {
			throw new ArithmeticException("Erro: não é possível calcular a raiz quadrada de um número negativo.");
		}

		return Math.sqrt(numero);
	}

	// Motor de cálculo para operações com dois valores

	public static double calcular(double valor1, String operador, double valor2) {

		if (operador == null) {
			throw new IllegalArgumentException("Erro: o operador não pode ser nulo.");
		}

		switch (operador.trim()) {

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

		default:
			throw new IllegalArgumentException("Erro: o operador '" + operador + "' não é suportado.");
		}
	}

	// Motor de cálculo para operações com um valor

	public static double calcular(double valor, String operador) {

		if (operador == null) {
			throw new IllegalArgumentException("Erro: o operador não pode ser nulo.");
		}

		switch (operador.trim()) {

		case "v":
			return radiciar(valor);

		default:
			throw new IllegalArgumentException(
					"Erro: o operador '" + operador + "' não é suportado para esta operação.");
		}
	}
}
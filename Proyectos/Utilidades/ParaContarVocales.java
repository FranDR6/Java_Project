package Utilidades;

import java.util.Scanner;

public class ParaContarVocales {
	public static void main(String[] args) {
		char[] vocales = { 'a', 'e', 'i', 'o', 'u' };
		int[] contador = { 0, 0, 0, 0, 0 };
		@SuppressWarnings("resource")
		Scanner valor = new Scanner(System.in);
		String cadena = valor.nextLine();
		for (int i = 0; i < cadena.length(); i++) {
			otraForma2(vocales, contador, cadena, i);
			otraForma1(contador, cadena, i);
		}
		for (int i = 0; i < contador.length; i++) {
			System.out.println(vocales[i] + ": " + contador[i] + " ");
		}
	}

	private static void otraForma2(char[] vocales, int[] contador, String cadena, int i) {
		for (int j = 0; j < vocales.length; j++) {
			if (cadena.toLowerCase().charAt(i) == vocales[j]) {
				contador[j]++;
			}
		}
	}

	private static void otraForma1(int[] contador, String cadena, int i) {
		switch (cadena.toLowerCase().charAt(i)) {
		case 'a':
			contador[0]++;
			break;
		case 'e':
			contador[1]++;
			break;
		case 'i':
			contador[2]++;
			break;
		case 'o':
			contador[3]++;
			break;
		case 'u':
			contador[4]++;
			break;
		}
	}
}

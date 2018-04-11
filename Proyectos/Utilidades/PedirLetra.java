package Utilidades;

import java.util.Scanner;

public class PedirLetra {
	public static void main(String[] args) {
		if(pedirLetra()=='Y')
			if(pedirLetra()=='N')
				if(pedirLetra()=='V')
					System.out.println("es correcto");
	}

	public static char pedirLetra() {
		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);
		char letra = leer.nextLine().charAt(0);
		letra = Character.toUpperCase(letra);
		return letra;
	}
}

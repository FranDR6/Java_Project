package Buscador_Password;

import java.util.Scanner;

public class Contrasena {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner valor = new Scanner(System.in);
		System.out.println("INTRODUCE LA PASSWORD");
		String Password = valor.nextLine();
		boolean encontrado = false;

		// 33-127 caracteres espanoles
		int numeroDigitos = 1, minimo = 33, maximo = 127;

		for (int c = minimo; c < maximo && !encontrado; c++) {
			for (int b = minimo; b < maximo && !encontrado; b++) {
				for (int a = minimo; a < maximo && !encontrado; a++) {
					for (int i = minimo; i < maximo && !encontrado; i++) {
						for (int j = minimo; j < maximo && !encontrado; j++) {
							for (int k = minimo; k < maximo && !encontrado; k++) {

								String caracter = "";

								switch (numeroDigitos) {
								case 1:
									caracter += String.valueOf(generarLetra(k));
									break;
								case 2:
									caracter += String.valueOf(generarLetra(j)) + String.valueOf(generarLetra(k));
									break;
								case 3:
									caracter += String.valueOf(generarLetra(i)) + String.valueOf(generarLetra(j))
											+ String.valueOf(generarLetra(k));
									break;
								case 4:
									caracter += String.valueOf(generarLetra(a)) + String.valueOf(generarLetra(i))
											+ String.valueOf(generarLetra(j)) + String.valueOf(generarLetra(k));
									break;
								case 5:
									caracter += String.valueOf(generarLetra(b)) + String.valueOf(generarLetra(a))
											+ String.valueOf(generarLetra(i)) + String.valueOf(generarLetra(j))
											+ String.valueOf(generarLetra(k));
									break;
								case 6:
									caracter += String.valueOf(generarLetra(c)) + String.valueOf(generarLetra(a))
											+ String.valueOf(generarLetra(i)) + String.valueOf(generarLetra(j))
											+ String.valueOf(generarLetra(k));
									break;
								}
//								System.out.println(caracter);
								if (Password.compareTo(caracter) == 0) {
									encontrado = true;
									System.out.println("La contraseña es : " + caracter);
								}

							}
							if (numeroDigitos == 1)
								numeroDigitos++;
						}
						if (numeroDigitos == 2)
							numeroDigitos++;
					}
					if (numeroDigitos == 3)
						numeroDigitos++;
				}
				if (numeroDigitos == 4)
					numeroDigitos++;
			}
			if (numeroDigitos == 5)
				numeroDigitos++;
		}
		if (numeroDigitos == 6)
			numeroDigitos++;
	}

	private static char generarLetra(int k) {
		char letra = (char) k;
		return letra;
	}
}

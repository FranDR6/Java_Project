package Buscador_Password;

public class Buscador {

	public static void main(String[] args) {

		boolean encontrado = false;
		int max = 127;
		int min = 33;
		int contador = 0;
		String password = "1234";

		do {
			String palabra = "";

			for (int i = min, k = min, t = min, q = min, w = min; i < max; i++, k++, t++, q++, w++) {

				switch (contador) {
				case 1:
					System.out.println(palabra += meterLetra(i));
					break;
				case 2:
					System.out.println(palabra += meterLetra(i) + meterLetra(k));
					break;
				case 3:
					System.out.println(palabra += meterLetra(i) + meterLetra(k) + meterLetra(t));
					break;
				case 4:
					System.out.println(palabra += meterLetra(i) + meterLetra(k) + meterLetra(t) + meterLetra(q));
					break;
				case 5:
					System.out.println(
							palabra += meterLetra(i) + meterLetra(k) + meterLetra(t) + meterLetra(q) + meterLetra(w));
					break;
				}
				
				System.out.println(palabra);

				if (password.compareTo(palabra) == 0) {
					System.out.println("La contraseña es: " + palabra);
					break;
				}

			}
			contador++;

		} while (!encontrado);
	}

	private static String meterLetra(int i) {
		return String.valueOf(generarLetra(i));
	}

	private static char generarLetra(int i) {
		char letra = (char) i;
		return letra;
	}
}

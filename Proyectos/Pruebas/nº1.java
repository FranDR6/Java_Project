package Pruebas;

public class nº1 {
	public static void main(String[] args) {
		int contador = 0;
		do {
			System.out.println("hola");
			sumaContador(contador);

		} while (contador != 100);
	}

	private static int sumaContador(int contador) {
		return contador++;
	}
}

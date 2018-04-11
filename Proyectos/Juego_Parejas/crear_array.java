package Juego_Parejas;

public class crear_array {
	public static void main(String[] args) {
		int parejas = 10;
		int tablero[] = new int[parejas * 2];
		crear_array_numeros(tablero);
		for (int i = 0; i < tablero.length; i++) {
			System.out.print(tablero[i] + "\t");
		}
	}

	private static int[] crear_array_numeros(int[] array) {
		for (int i = 0, k = 1; i < array.length; i++, k++) {
			if (i == array.length / 2) {
				k = 1;
			}
			array[i] = k;
		}
		desordenarArrayNumeros(array);
		return array;
	}

	private static void desordenarArrayNumeros(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int t = array[i];
			int y = (int) (Math.random() * array.length);
			array[i] = array[y];
			array[y] = t;
		}
	}
}

// @Override
// public void crearTablero(Dificultad dificultad) {
// int[] arrayNumeros = new int[dificultad*2];
// crear_array_numeros(arrayNumeros);
// for (int i = 0; i < arrayNumeros.length; i++) {
// this.cartas[i].setId(arrayNumeros[i]);
// }
//
// }
//
// private static int[] crear_array_numeros(int[] array) {
// for (int i = 0, k = 1; i < array.length; i++, k++) {
// if (i == array.length / 2) {
// k = 1;
// }
// array[i] = k;
// }
// desordenarArrayNumeros(array);
// return array;
// }
//
// private static void desordenarArrayNumeros(int[] array) {
// for (int i = 0; i < array.length; i++) {
// int t = array[i];
// int y = (int) (Math.random() * array.length);
// array[i] = array[y];
// array[y] = t;
// }
// }
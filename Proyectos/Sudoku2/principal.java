package Sudoku2;

public class principal {
	public static void main(String[] args) {
		int[][][][] tablero = new int[3][3][3][3];
		int[][] tableroFinal;
		crearTablero(tablero);
		do {
			desordenarTablero(tablero);
			tableroFinal = crearMatriz(tablero);
			mostrarMatriz(tableroFinal);
			System.out.println("------------------------------------------------");
		} while (validarTablero(tableroFinal) == true);
	}

	private static boolean validarTablero(int[][] array) {
		for (int a = 0; a < array.length; a++) {
			for (int b = 0; b < array.length; b++) {
				if (comprobarColumnaFila(array, a, b) == true) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean comprobarColumnaFila(int[][] array, int a, int b) {
		for (int e = 0; e < array.length; e++) {
			if (array[a][b] == array[a][e] && e != b) {
				return true;
			}
			if (array[a][b] == array[e][b] && e != a) {
				return true;
			}
		}
		return false;
	}

	private static int[][] crearMatriz(int[][][][] array) {
		int[][] tableroMatriz = new int[array.length * 3][array.length * 3];
		int e = 0, f = 0;
		for (int a = 0, g = 0; a < tableroMatriz.length; a++) {

			for (int b = 0, t = 0; b < tableroMatriz.length; b++) {
				if (a == 0 || a == 3 || a == 6) {
					f = 0;
				}
				if (a == 1 || a == 4 || a == 7) {
					f = 1;
				}
				if (a == 2 || a == 5 || a == 8) {
					f = 2;
				}
				if (b == 0 || b == 3 || b == 6) {
					e = 0;
				}
				if (b == 1 || b == 4 || b == 7) {
					e = 1;
				}
				if (b == 2 || b == 5 || b == 8) {
					e = 2;
				}
				tableroMatriz[a][b] = array[g][t][f][e];
				if (b == 2 || b == 5) {
					t++;
				}
			}
			if (a == 2 || a == 5) {
				g++;
			}
		}
		return tableroMatriz;
	}

	private static void desordenarTablero(int[][][][] array) {
		int contenedor;
		for (int a = 0; a < array.length; a++) {
			for (int b = 0; b < array.length; b++) {
				for (int c = 0; c < array.length; c++) {
					for (int d = 0; d < array.length; d++) {
						contenedor = array[a][b][c][d];
						int posicionA = (int) (Math.random() * array.length);
						int posicionB = (int) (Math.random() * array.length);
						array[a][b][c][d] = array[a][b][posicionA][posicionB];
						array[a][b][posicionA][posicionB] = contenedor;
					}
				}
			}
		}
	}

	private static void crearTablero(int[][][][] array) {
		int[] numeros = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		for (int a = 0; a < array.length; a++) {
			for (int b = 0; b < array.length; b++) {
				for (int c = 0, e = 0; c < array.length; c++) {
					for (int d = 0; d < array.length; d++, e++) {
						array[a][b][c][d] = numeros[e];
					}
				}
			}
		}
	}

	private static void mostrarMatriz(int[][] matriz) {
		for (int x = 0; x < matriz.length; x++) {
			System.out.print(" ");
			for (int y = 0; y < matriz[x].length; y++) {
				System.out.print(matriz[x][y]);
				if (y != matriz[x].length - 1)
					System.out.print("\t");
			}
			System.out.println(" ");
		}
	}
}

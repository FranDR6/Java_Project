package Utilidades;

public class MotrarMatrices {
	public static void main(String[] args) {
		int[][] matriz = new int[1][1];
		mostrarMatriz(matriz);
	}

	// MUESTRA LA MATRIZ
	private static void mostrarMatriz(int[][] matriz) {
		for (int x = 0; x < matriz.length; x++) {
			System.out.print("|");
			for (int y = 0; y < matriz[x].length; y++) {
				System.out.print(matriz[x][y]);
				if (y != matriz[x].length - 1)
					System.out.print("\t");
			}
			System.out.println("|");
		}
	}

	// MUESTRA LA MATRIZ CON NUMEROS EN LA FILAS Y COLUMNAS
	@SuppressWarnings("unused")
	private static void mostrarMatrizString(String[][] matriz) {
		for (int x = 0, q = 1; x < matriz.length; x++, q++) {
			if (x == 0) {
				for (int i = 0; i < matriz.length; i++) {
					System.out.print(" \t" + (i + 1) + "");
				}
				System.out.println("");
			}
			System.out.print("\n");
			for (int y = 0; y < matriz[x].length; y++) {
				if (y == 0) {
					System.out.print(q + "");
				}

				System.out.print("\t" + matriz[x][y] + "");
			}
			System.out.println("");
		}
	}
}

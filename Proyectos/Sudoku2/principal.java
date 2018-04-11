package Sudoku2;

public class principal {
	public static void main(String[] args) {
		int[][][][] tablero = new int[3][3][3][3];

	
		int[][] crearArea = crearArea3x3();
		mostrarMatriz(crearArea);

	}

	private static int[][] crearArea3x3() {
		int[] numero = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[][] crearArea = new int[3][3];
		for (int i = 0, x = 0, y = 0; i < numero.length; i++) {
			do {
				x = (int) (Math.random() * crearArea.length);
				y = (int) (Math.random() * crearArea.length);
			} while (crearArea[x][y] != 0);
			crearArea[x][y] = numero[i];
		}
		return crearArea;
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

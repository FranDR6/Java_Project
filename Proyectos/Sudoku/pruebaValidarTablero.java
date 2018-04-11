package Sudoku;

public class pruebaValidarTablero {
	public static void main(String[] args) {
		int sudoku[][]= {
									{2,1,5,9,3,8,4,6,7},
									{7,8,6,1,2,4,3,5,9},
									{9,3,4,6,5,7,2,8,1},
									{8,6,9,5,4,2,1,7,3},
									{1,4,3,7,8,6,5,9,2},
									{5,2,7,3,9,1,8,4,6},
									{6,7,2,4,1,5,9,3,8},
									{4,9,8,2,6,3,7,1,5},
									{3,5,1,8,7,9,6,2,4}};
		System.out.println(validarTablero(sudoku));
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
}

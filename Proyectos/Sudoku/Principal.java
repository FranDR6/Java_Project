package Sudoku;

public class Principal {
	public static void main(String[] args) {
		Tablero sudoku = new Tablero();
		for (int i = 0; i < sudoku.tablero.length; i++) {
			for (int j = 0; j < sudoku.tablero.length; j++) {
				
			}
		}
		mostrarArea(sudoku.tablero);
		System.out.println("");
		mostrarNumero(sudoku.tablero);
		
	}

	private static void mostrarNumero(Numero[][] tablero) {
		for (int x = 0; x < tablero.length; x++) {
			System.out.print("|");
			for (int y = 0; y < tablero[x].length; y++) {
				System.out.print(tablero[x][y].getNumero());
				if (y != tablero[x].length - 1)
					System.out.print("\t");
			}
			System.out.println("|");
		}
	}
	private static void mostrarArea(Numero[][] tablero) {
		for (int x = 0; x < tablero.length; x++) {
			System.out.print("|");
			for (int y = 0; y < tablero[x].length; y++) {
				System.out.print(tablero[x][y].getArea());
				if (y != tablero[x].length - 1)
					System.out.print("\t");
			}
			System.out.println("|");
		}
	}
}

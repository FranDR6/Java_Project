package Sudoku;

public class Tablero {
	private Casilla[][] sudoku = new Casilla[9][9];

	public Casilla[][] getSudoku() {
		return sudoku;
	}

	public void setSudoku(Casilla[][] sudoku) {
		this.sudoku = sudoku;
	}

	public Tablero() {
		super();
		for (int x = 0; x < this.sudoku.length; x++) {
			for (int y = 0; y < this.sudoku.length; y++) {
				this.sudoku[x][y] = new Casilla();
				asignarArea(x, y, this.sudoku);
			}
		}
		do {
			asiganarNumeros(this.sudoku);
			mostrarSudoku(sudoku);
		} while (validarSudoku(this.sudoku) == true);

	}
	private static void mostrarSudoku(Casilla[][] sudoku) {
		for (int x = 0; x < sudoku.length; x++) {
			System.out.print(" ");
			for (int y = 0; y < sudoku[x].length; y++) {
				System.out.print(sudoku[x][y].getNumero());
				if (y != sudoku[x].length - 1)
					System.out.print("\t");
			}
			System.out.println(" ");
		}
	}

	private static boolean validarSudoku(Casilla[][] sudoku) {
		for (int a = 0; a < sudoku.length; a++) {
			for (int b = 0; b < sudoku.length; b++) {
				for (int e = 0; e < sudoku.length; e++) {
					if (sudoku[a][b].getNumero() == sudoku[a][e].getNumero() && e != b) {
						return true;
					}
					if (sudoku[a][b].getNumero() == sudoku[e][b].getNumero() && e != a) {
						return true;
					}
				}
				for (int i = 0; i < sudoku.length; i++) {
					for (int j = 0; j < sudoku.length; j++) {
						if (sudoku[a][b].getNumero() == sudoku[i][j].getNumero()
								&& sudoku[a][b].getArea() == sudoku[i][j].getArea() && i != a && j != b) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	private void asiganarNumeros(Casilla[][] sudoku) {
		for (int a = 0; a < this.sudoku.length; a++) {
			for (int b = 0; b < this.sudoku.length; b++) {
				int intentos = 100;
				do {
					this.sudoku[a][b].setNumero((int) (Math.random() * 9) + 1);
					intentos--;
				} while (validarCasilla(this.sudoku, a, b) == true || intentos > 0);
				mostrarSudoku(sudoku);
				System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀");
			}
		}
	}

	private boolean validarCasilla(Casilla[][] sudoku, int a, int b) {
		for (int x = 0; x < sudoku.length; x++) {
			if (this.sudoku[a][b].getNumero() == this.sudoku[a][x].getNumero() && x != b) {
				return true;
			}
			if (this.sudoku[a][b].getNumero() == this.sudoku[x][b].getNumero() && x != a) {
				return true;
			}
		}
		for (int i = 0; i < sudoku.length; i++) {
			for (int j = 0; j < sudoku.length; j++) {
				if (this.sudoku[a][b].getNumero() == this.sudoku[i][j].getNumero()
						&& this.sudoku[a][b].getArea() == this.sudoku[i][j].getArea() && i != a && j != b) {
					return true;
				}
			}
		}
		return false;
	}

	private static void asignarArea(int x, int y, Casilla[][] sudoku) {
		int a = 0;
		int[][] filas = { { 0, 0, 0, 1, 1, 1, 2, 2, 2 }, { 3, 3, 3, 4, 4, 4, 5, 5, 5 }, { 6, 6, 6, 7, 7, 7, 8, 8, 8 } };
		if (x <= 2) {
			a = 0;
			sudoku[x][y].setArea(filas[a][y]);
		}
		if (x >= 3 && x <= 5) {
			a = 1;
			sudoku[x][y].setArea(filas[a][y]);
		}
		if (x >= 6) {
			a = 2;
			sudoku[x][y].setArea(filas[a][y]);
		}
	}
}

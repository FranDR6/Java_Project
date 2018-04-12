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
			System.out.println("---------------------------------------------");
		} while (comprobarCero(sudoku) == true);

	}

	private boolean comprobarCero(Casilla[][] sudoku) {
		for (int a = 0; a < sudoku.length; a++) {
			for (int b = 0; b < sudoku.length; b++) {
				if (sudoku[a][b].getNumero() == 0) {
					return true;
				}
			}
		}
		return false;
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

	private void asiganarNumeros(Casilla[][] sudoku) {
		boolean salir = false;
		int[] numeros = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		for (int a = 0; a < this.sudoku.length; a++) {
			for (int b = 0, intentos = 0; b < this.sudoku.length; b++) {
				do {
					this.sudoku[a][b].setNumero(numeros[(int) (Math.random() * numeros.length)]);
					intentos++;
					if (intentos == 500) {
						this.sudoku[a][b].setNumero(0);
						break;
					}
				} while (validarCasilla(this.sudoku, a, b) == true);
				if (this.sudoku[a][b].getNumero() == 0) {
					salir = true;
					break;
				}
			}
			if (salir == true) {
				break;
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

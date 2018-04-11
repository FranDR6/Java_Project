package Sudoku;

public class Tablero {
	public Numero[][] tablero = new Numero[9][9];

	// --------------------------------------------------------------------------------------//
	public Numero[][] getTablero() {
		return tablero;
	}

	public void setTablero(Numero[][] tablero) {
		this.tablero = tablero;
	}
	// --------------------------------------------------------------------------------------//

	public Tablero() {
		super();
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				this.tablero[i][j] = new Numero();
				ponerArea(i, j, tablero);
			}
		}
		colocarNumeros();
	}
	// --------------------------------------------------------------------------------------//

	private void colocarNumeros() {
		int[] ejeX = { 0, 0, 0, 3, 3, 3, 5, 5, 5 };
		int[] ejeY = { 0, 3, 5, 0, 3, 5, 0, 3, 5 };
		for (int i = 0; i < ejeY.length; i++) {
			for (int j = 0; j < ejeY.length; j++) {
				int[] numero= {};
				for (int x = ejeX[i],e=0; x < x + 2; x++) {
					for (int y = ejeY[j]; y < y + 2; y++,e++) {
						do {
							tablero[x][y].setNumero((int) (Math.random() * 8) + 1);
						} while (comprobarColumnaFila(x, y) && comprobarNumero(numero,x,y));
						numero[e]=tablero[x][y].getNumero();
						System.out.println("*");
					}
				}
			}
		}
	}

	private boolean comprobarNumero(int[] numero,int x,int y) {
		for (int i = 0; i < numero.length; i++) {
			if (tablero[x][y].getNumero()==numero[i]) {
				return true;
			}
		}
		return false;
	}

	private boolean comprobarColumnaFila(int x, int y) {
		for (int e = 0; e < tablero.length; e++) {
			// COLUMNA
			if (tablero[x][y].getNumero() == tablero[e][y].getNumero() && e != x) {
				return true;
			}
			// FILA
			if (tablero[x][y].getNumero() == tablero[x][e].getNumero() && e != y) {
				return true;
			}
		}
		// AREA
//		for (int i = 0; i < tablero.length; i++) {
//			for (int j = 0; j < tablero.length; j++) {
//				if (tablero[x][y].getArea() == tablero[i][j].getArea()
//						&& tablero[x][y].getNumero() == tablero[i][j].getNumero() && i != x && j != y) {
//					return true;
//				}
//			}
//		}
		return false;
	}

	private void ponerArea(int x, int y, Numero[][] tablero) {
		int a = 0;
		int[][] array = { { 0, 0, 0, 1, 1, 1, 2, 2, 2 }, { 3, 3, 3, 4, 4, 4, 5, 5, 5 }, { 6, 6, 6, 7, 7, 7, 8, 8, 8 } };
		if (x <= 2) {
			a = 0;
			this.tablero[x][y].setArea(array[a][y]);
		}
		if (x >= 3 && x <= 5) {
			a = 1;
			this.tablero[x][y].setArea(array[a][y]);
		}
		if (x >= 6) {
			a = 2;
			this.tablero[x][y].setArea(array[a][y]);
		}
	}
}

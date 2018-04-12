package Busca_Minas_Consola;

import java.util.Scanner;

public class BuscaMinasConsola {
	public static void main(String[] args) {
		int Tama = 30 + 2, Minas = 10, a, b;
		int[][] tablero = new int[Tama][Tama];
		String[][] tableroVisible = new String[Tama - 2][Tama - 2];
		boolean Win = true, GameOver = false;
		// --------------------------------------------------------------------------------------------//
		crearTablero(Tama, Minas, tablero, tableroVisible);
		do {
			Win = true;
			mostrarMatrizString(tableroVisible);
			System.out.println("\n");
			// --------------------------------------------------------------------------------------------//
			@SuppressWarnings("resource")
			Scanner valor = new Scanner(System.in);
			System.out.println("Introduce la fila.");
			a = 1 + valor.nextInt();
			System.out.println("introduce la columna");
			b = 1 + valor.nextInt();
			desvelarCasillas(tablero, a, b, tableroVisible);
			if (tablero[a][b] > 0 && tablero[a][b] < 9) {
				tableroVisible[a - 1][b - 1] = String.valueOf(tablero[a][b]);
			}
			if (tablero[a][b] == -1)
				GameOver = true;
			for (int i = 0; i < tableroVisible.length; i++) {
				for (int j = 0; j < tableroVisible.length; j++) {
					if (tableroVisible[i][j] == "â–€" && tablero[i + 1][j + 1] != -1) {
						Win = false;
					}
				}
			}

		} while (Win == true && !GameOver);
		if (GameOver == true) {
			System.out.println("GameOver");
		}
		if (Win == true) {
			System.out.println("Win");
		}

		// --------------------------------------------------------------------------------------------//
	}

	private static void mostrarMatrizString(String[][] matriz) {
		for (int x = 0, q = 0; x < matriz.length; x++, q++) {
			if (x == 0) {
				for (int i = 0; i < matriz.length; i++) {
					System.out.print(" \t" + (i) + "");
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
		}
	}

	private static void crearTablero(int Tama, int Minas, int[][] tablero, String[][] tableroVisible) {
		int q, w;
		for (int i = 0; i < Minas; i++) {
			do {
				q = (int) (Math.random() * ((Tama - 1) - 1)) + 1;
				w = (int) (Math.random() * ((Tama - 1) - 1)) + 1;
			} while (tablero[q][w] == -1);
			tablero[q][w] = -1;
		}

		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				if (tablero[i][j] == -1) {
					for (int r = i - 1; r < i + 2; r++) {
						for (int k = j - 1; k < j + 2; k++) {
							if (tablero[r][k] != -1) {
								tablero[r][k]++;
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				if (i == 0 || j == 0 || i == Tama - 1 || j == Tama - 1) {
					tablero[i][j] = 10;
				}
			}
		}
		for (int i = 0; i < tableroVisible.length; i++) {
			for (int j = 0; j < tableroVisible.length; j++) {
				// Alt+223 = â–€ .. Alt+10 = â—™
				tableroVisible[i][j] = "▀";
			}
		}
	}

	private static void desvelarCasillas(int[][] tablero, int a, int b, String[][] tableroVisible) {
		if (tablero[a][b] == 0) {
			tablero[a][b] = 20;
			// Alt+1 = â˜º
			tableroVisible[a - 1][b - 1] = "☺";
			for (int i = a - 1; i < a + 2; i++) {
				for (int j = b - 1; j < b + 2; j++) {
					if (tablero[i][j] == 0) {
						desvelarCasillas(tablero, i, j, tableroVisible);
					} else {
						if (tablero[i][j] > 0 && tablero[i][j] < 9) {
							tableroVisible[i - 1][j - 1] = String.valueOf(tablero[i][j]);
						}
					}
				}
			}
		}
	}
}
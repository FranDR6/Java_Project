package Sudoku;

public class Prueba {
	public static void main(String[] args) {
		Tablero user=new Tablero();
		for (int i = 0; i < user.getSudoku().length; i++) {
			for (int j = 0; j < user.getSudoku().length; j++) {
				System.out.println(user.getSudoku()[i][j].getNumero());
			}
		}
	}
}

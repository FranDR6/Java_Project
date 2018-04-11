package Utilidades;

public class GenerarNumeroAleatoriosSinRepetir {
public static void main(String[] args) {
	int[] mano=new int[2];
	int[] baraja=new int[2];
	int i = 0, cantidad = 5, rango = 52;
	int cincoNumeros[] = new int[cantidad];
	cincoNumeros[i] = (int) (Math.random() * rango);
	for (i = 1; i < cantidad; i++) {
		cincoNumeros[i] = (int) (Math.random() * rango);
		for (int j = 0; j < i; j++) {
			if (cincoNumeros[i] == cincoNumeros[j]) {
				i--;
			}
		}
	}

	for (int j = 0; j < mano.length; j++) {
		mano[j] = baraja[cincoNumeros[j]];

	}
}
}

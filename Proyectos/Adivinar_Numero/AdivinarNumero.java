package Adivinar_Numero;

import java.util.Scanner;

public class AdivinarNumero implements Jugar {
	private int numeroSecreto;
	private int intentos;

	public AdivinarNumero() {
		numeroSecreto = (int) (Math.random() * 100 - 1) + 1;
		intentos = 10;
	}

	public int getNumeroSecreto() {
		return numeroSecreto;
	}

	public void setNumeroSecreto(int numeroSecreto) {
		this.numeroSecreto = numeroSecreto;
	}

	public int getContadorintentos() {
		return intentos;
	}

	public void setContadorintentos(int contadorintentos) {
		this.intentos = contadorintentos;
	}

	public void jugar() {
		int a;
		do {
			System.out.println("Adivina el numero que esta entre 1-100(Tienes " + this.intentos + " intentos).");
			a = introducirNumeros();
			this.intentos--;
			if (this.numeroSecreto != a && this.intentos > 0) {
				mensajeAyuda(a);
			}
		} while (this.numeroSecreto != a && this.intentos > 0);
		if (this.numeroSecreto == a) {
			System.out.println("WIN!!");
		} else {
			System.out.println("GameOver");
		}
	}

	private void mensajeAyuda(int a) {
		if (this.numeroSecreto > a) {
			System.out.println("El numero que has introducido es mas pequeño.");
		} else {
			System.out.println("El numero que has introducido es mas grande.");
		}
	}

	public int introducirNumeros() {
		@SuppressWarnings("resource")
		Scanner valor = new Scanner(System.in);
		return valor.nextInt();
	}
}

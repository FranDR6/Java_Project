package Kata_Password;

public class PassWord implements Generable {
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String generatePassword(int letter, int numbers, int symbols) {
		String[] numeros = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		String[] simbolos = { "@", "#", "%", "&", "$", "!", "?", "�" };
		String[] letras = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
				"s", "t", "x", "w", "x", "y", "z" };
		String contrase�a = new String();
		int longitudContrase�a = letter + numbers + symbols;
		String[] cadena = new String[longitudContrase�a];
		generarCadena(letter, numbers, symbols, numeros, simbolos, letras, cadena);
		desordenarCadena(longitudContrase�a, cadena);
		contrase�a = crearPaasword(contrase�a, cadena);
		return this.password = contrase�a;
	}

	private String crearPaasword(String contrase�a, String[] cadena) {
		for (int i = 0; i < cadena.length; i++) {
			contrase�a = contrase�a.concat(cadena[i]);
		}
		return contrase�a;
	}

	private void desordenarCadena(int longitudContrase�a, String[] cadena) {
		for (int i = 0, numero; i < cadena.length; i++) {
			numero = (int) (Math.random() * longitudContrase�a);
			String temporal = cadena[i];
			cadena[i] = cadena[numero];
			cadena[numero] = temporal;
		}
	}

	private void generarCadena(int letter, int numbers, int symbols, String[] numeros, String[] simbolos,
			String[] letras, String[] cadena) {
		int i = 0;
		for (int numero; i < numbers; i++) {
			numero = (int) (Math.random() * numeros.length);
			cadena[i] = numeros[numero];
		}
		for (int numero; i < letter + numbers; i++) {
			numero = (int) (Math.random() * letras.length);
			cadena[i] = letras[numero];
		}
		for (int numero; i < symbols + numbers + letter; i++) {
			numero = (int) (Math.random() * simbolos.length);
			cadena[i] = simbolos[numero];
		}
	}

}

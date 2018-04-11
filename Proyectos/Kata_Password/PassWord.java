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
		String[] simbolos = { "@", "#", "%", "&", "$", "!", "?", "¿" };
		String[] letras = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
				"s", "t", "x", "w", "x", "y", "z" };
		String contraseña = new String();
		int longitudContraseña = letter + numbers + symbols;
		String[] cadena = new String[longitudContraseña];
		generarCadena(letter, numbers, symbols, numeros, simbolos, letras, cadena);
		desordenarCadena(longitudContraseña, cadena);
		contraseña = crearPaasword(contraseña, cadena);
		return this.password = contraseña;
	}

	private String crearPaasword(String contraseña, String[] cadena) {
		for (int i = 0; i < cadena.length; i++) {
			contraseña = contraseña.concat(cadena[i]);
		}
		return contraseña;
	}

	private void desordenarCadena(int longitudContraseña, String[] cadena) {
		for (int i = 0, numero; i < cadena.length; i++) {
			numero = (int) (Math.random() * longitudContraseña);
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

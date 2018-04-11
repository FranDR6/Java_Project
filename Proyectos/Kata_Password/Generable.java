package Kata_Password;

public interface Generable {

	/**
	 * Genera una cadena que mezcla letras, numeros y simbolos en la cantidad
	 * indicada en los parametros, pueden ser en mayusculas o minusculas
	 * 
	 * @param letter letras del alfabeto occidental (ni ñ ni ç) 
	 * @param numbers del 0 al 9
	 * @param symbols simbolos imprimibles ortográficos
	 * @return la cadena con la longitud resultante de la suma de letters+numbers+symbols
	 */
	public String generatePassword(int letter,int numbers,int symbols);
}

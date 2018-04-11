package Kata_Password;

public class Principal {
public static void main(String[] args) {
	PassWord password=new PassWord();
	password.generatePassword(5, 4, 2);
	System.out.println("La password es: "+password.getPassword());
}
}

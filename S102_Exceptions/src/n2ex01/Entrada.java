package n2ex01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Entrada {

	private static Scanner sc = new Scanner(System.in);
	
	// Mètodes a implantar capturant l’excepció de la classe InputMismatchException:
	public static byte llegirByte(String msg) {
		byte valor = 0;
		boolean esUnByte = false;
		
		do {
			try {
				System.out.println(msg);
				valor = sc.nextByte();
				esUnByte = true;
				return valor;
			} catch(InputMismatchException e) {
				System.out.println("Error de format: " + e.getMessage());
			}
			sc.nextLine();
		} while(!esUnByte);
		return valor;
	}
	
	public static int llegirInt(String msg) {
		int valor = 0;
		boolean esUnInt = false;
		
		do {
			try {
				System.out.println(msg);
				valor = sc.nextInt();
				esUnInt = true;
			} catch(InputMismatchException e) {
				System.out.println("Error de format: " + e.getMessage());
			}
			sc.nextLine();
		} while(!esUnInt);
		return valor;
	}
	
	public static float llegirFloat(String msg) {
		float valor = 0.0f;
		boolean esUnFloat = false;
		
		do {
			try {
				System.out.println(msg);
				valor = sc.nextFloat();
				esUnFloat = true;
			} catch(InputMismatchException e) {
				System.out.println("Error de format: " + e.getMessage());
			}
			sc.nextLine();
		} while(!esUnFloat);
		return valor;
	}
	
	public static double llegirDouble(String msg) {
		double valor = 0.0d;
		boolean esUnDouble = false;
		
		do {
			try {
				System.out.println(msg);
				valor = sc.nextDouble();
				esUnDouble = true;
			} catch(InputMismatchException e) {
				System.out.println("Error de format: " + e.getMessage());
			}
			sc.nextLine();
		} while(!esUnDouble);
		return valor;
	}
	
	// Mètodes a implantar capturant l’excepció de la classe Exception:
	public static char llegirChar(String msg) {
		String cadena = "";
		char valor = ' ';
		boolean esUnChar = false;
		
		do {
			System.out.println(msg);
			try {
				cadena = sc.nextLine();
				if(cadena.length() > 1) {
					throw new Exception();
				} else {
					valor = cadena.charAt(0);
					esUnChar = true;
				}
			} catch(Exception e) {
				System.out.println("Introdueix només un caràcter");
			}
			sc.nextLine();
		} while(!esUnChar);
		return valor;
	}
	
	public static String llegirString(String msg) {
		String valor = "";
		boolean esUnString = false;
		String regExpr = "^[0-9]+$";
		
		do {
			System.out.println(msg);
			try {
				valor = sc.nextLine();
				// si es un caract. o només hi ha núms. > error
				if(valor.length() <= 1 || valor.matches(regExpr) ) {
					throw new Exception();
				}
				esUnString = true;
			} catch(Exception e) {
				System.out.println("Error de format: No pots introduir només números, ni només un sol caracter." + e.getMessage());
			}
		} while(!esUnString);
		return valor;
	}
	
	/** 
	 * usuari introdueix "s" retorna true
	 * usuari introdueix "n" retorna false
	 * */
	
	public static boolean llegirSiNo(String msg) {
		char valor = ' ';
		boolean esCorrecte = false;
		boolean esSi = false;
		
		do {
			System.out.println(msg);
			try {
				valor = sc.nextLine().charAt(0);
				if(valor == 's') {
					esSi = true;
					esCorrecte = true;
				} else if(valor == 'n') {
					esSi = false;
					esCorrecte = true;
				} else {
					throw new Exception();
				}
			} catch(Exception e) {
				System.out.println("Error de format: Introdueix 's' per si i 'n' per no" + e.getMessage());
			}
		} while(!esCorrecte);
		
		return esSi;
	}
	
	
	
	
	
	
}
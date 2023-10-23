package n2ex01;

public class Main {

	public static void main(String[] args) {
		
		// Provant mètodes que capturen l’excepció de la classe InputMismatchException:
		byte resultatByte = Entrada.llegirByte("Introdueixi un byte");
		System.out.println("Resultat byte:" + resultatByte);
		
		int resInt = Entrada.llegirInt("Introdueixi un nombre enter");
		System.out.println("Resultat int:" + resInt);

		float resFloat = Entrada.llegirFloat("Introdueixi un float");
		System.out.println("Resultat float:" + resFloat);

		double resDouble = Entrada.llegirDouble("Introdueixi un double");
		System.out.println("Resultat double:" + resDouble);

		//Mètodes a implantar capturant l’excepció de la classe Exception:
		char resChar = Entrada.llegirChar("Introdueixi un caràcter");
		System.out.println("Ha introduït el caràcter:" + resChar);

		String resString = Entrada.llegirString("Introdueixi una frase");
		System.out.println("Ha introduït la frase:" + resString);

		boolean resBoolean = Entrada.llegirSiNo("Li agrada omplir qüestionaris: introdueixi 's' per sí i 'n' per no");
		System.out.println("ResuHa introduït:" + resBoolean);
	}

}

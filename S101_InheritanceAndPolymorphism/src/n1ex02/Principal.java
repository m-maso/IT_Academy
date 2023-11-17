package n1ex02;

public class Principal {

	public static void main(String[] args) {
		
		System.out.println("Invocar mètode static (classe):");
		Cotxe.frenar();
		
		System.out.println("\nInvocar mètode no static(instància de la classe):");
		Cotxe cotxe1 = new Cotxe();
		cotxe1.accelerar();
		
		System.out.println("\ncotxe1: " + cotxe1.toString());
		
		//establim l'únic atribut que no és una constant
		Cotxe cotxe2 = new Cotxe();
		Cotxe.setModel("Civic");
		System.out.println("cotxe2 (canviem el model[atrib. static]): " + cotxe2.toString());
	}

}

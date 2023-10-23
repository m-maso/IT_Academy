package n1ex01;

public class Main {

	public static void main(String[] args) {
		
		Venda venda1 = new Venda();
		Producte prod1 = new Producte("Saxo", 555.5f);
		Producte prod2 = new Producte("Llibreta pentagrama", 2.56f);	
			// Error VendaBuidaException
		venda1.getProductes().add(prod1);
		venda1.getProductes().add(prod2);
		
//		Comprovar Error ArrayIndexOfBoundsException amb venda2
//		Venda venda2 = new Venda();
//		Producte prod1 = new Producte("Saxo", 555.5f);
//		Producte prod2 = new Producte("Llibreta pentagrama", 2.56f);	
//		Producte prod3 = new Producte("Piano", 2500);
//		
//		venda2.getProductes().add(prod1);
//		venda2.getProductes().add(prod2);
//		venda2.getProductes().add(prod3);
		
		try {
			venda1.calcularTotal();
//			venda2.calcularTotal();
		} catch(VendaBuidaException e) {
			System.out.println("Trobat VendaBuidaException: " + e.getMessage());
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Trobat ArrayIndexOfBoundsException: " + e.getMessage());
		}
			
	}
}
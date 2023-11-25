package n1ex01;

public class Main {

	public static void main(String[] args) {

		// EmptySaleException Error
		Sale sale1 = new Sale();
		
		try {
			sale1.calculateTotal();
		} catch(EmptySaleException e) {
			System.out.println("Found EmptySaleException: " + e.getMessage());
		}
		
		// ArrayIndexOfBoundsException Error 
		Sale sale2 = new Sale();
		Product prod1 = new Product("Tenor sax", 555.5f);
		Product prod2 = new Product("Music notebook (8 staves)", 2.56f);	
		Product prod3 = new Product("Piano", 2500);
				
		sale2.getProducts().add(prod1);
		sale2.getProducts().add(prod2);
		sale2.getProducts().add(prod3);

		try {
			sale2.printProducts();
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Found ArrayIndexOfBoundsException: " + e.getMessage());
		}
		
	}
	
}
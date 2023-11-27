package n1ex01;

import java.util.Scanner;

public class App {
	
	public static void main(String[] args) {
		
		// Undo instance
		Undo undo = Undo.getUndoInstance();
	
		Scanner sc = new Scanner(System.in);
		int option = 0;
		
		do {
			System.out.println("\nORDERS MENU\n"
					+ "1. Save last entered orders\n"
					+ "2. Add order\n"
					+ "3. Remove orders\n"
					+ "4. Show last entered orders\n"
					+ "0. Exit the app");
			option = sc.nextInt();
			sc.nextLine();
			
			switch(option) {
			case 0: 
				System.out.println("You're leaving the app");
				break;
			case 1:
				undo.saveLastOrders();
				break;
			case 2:
				System.out.println("Introduce a new order:");
				String order = sc.nextLine();
				undo.addOrder(order);
				break;
			case 3:
				undo.deleteOrder();
				break;
			case 4:
				undo.showLastSavedOrders();
				break;
			default:
				System.out.println("Enter a correct option number between 0 and 4");
				break;
			}
		} while(option != 0);
		
		sc.close();
	}

}

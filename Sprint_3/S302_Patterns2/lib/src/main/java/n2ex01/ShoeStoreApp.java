package n2ex01;

public class ShoeStoreApp {

	public static void main(String[] args) {

		ShoeStore store = new ShoeStore();
		
		// Payments with: 1. Credit Card, 2. Paypal, 3. Bank Transfer
		store.processPayment(1);
		store.processPayment(2);
		store.processPayment(3);
	}

}

package n2ex01;

public class ShoeStore {
	
	PaymentGateway PaymentGateway = new PaymentGateway();

	// First: do simple task
	public void processPayment(int paymentMethod) {
		switch(paymentMethod) {
			case 1:
				PaymentGateway.executeWith(
					() -> System.out.println("You're paying with Credit Card")
				);
				break;
			case 2:
				PaymentGateway.executeWith(
					() -> System.out.println("You're paying using Paypal")
				);
				break;
			case 3:
				PaymentGateway.executeWith(
					() -> System.out.println("You're paying by Bank Transfer")
				);
				break;
			default:
				System.err.println("Select a correct option between 1 and 3");
		}
	}
	

}
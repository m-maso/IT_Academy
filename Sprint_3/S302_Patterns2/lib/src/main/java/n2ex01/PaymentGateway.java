package n2ex01;

// SIMPLE TASK - extends TASK

public class PaymentGateway extends Payment {


	// Second: callback
	@Override
	public void execute() {
		System.out.println("You've paid successfully\n");
	
	}

}

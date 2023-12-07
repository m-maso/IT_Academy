package n1ex01;

import n1ex01.Observers.BcnBrokerage;
import n1ex01.Observers.LndBrokerage;
import n1ex01.Observers.TokioBrokerage;

// CLIENT

public class App {

	public static void main(String[] args) {
		
		Broker broker = new Broker();
		
		new BcnBrokerage(broker);
		new LndBrokerage(broker);
		new TokioBrokerage(broker);
		

		System.out.println("First state change:");
		broker.setstockPrice(8940.0d);
		System.out.println("\nSecond state change:");
		broker.setstockPrice(1154.95d);

	}

}

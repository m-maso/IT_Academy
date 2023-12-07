package n1ex01.Observers;

import n1ex01.Broker;
import n1ex01.Brokerage;

public class BcnBrokerage extends Brokerage {

	public BcnBrokerage(Broker broker) {
		this.subject = broker;
		this.subject.subscribe(this);
	}
	
	@Override
	public void update() {
		double stockUpdate = Math.round(1.2*subject.getstockPrice()*1000/1000);
		System.out.println("Hi BcnBrokerage, new stockprice updated: " + stockUpdate + "€");
	}

}

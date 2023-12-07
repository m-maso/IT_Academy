package n1ex01.Observers;

import n1ex01.Broker;
import n1ex01.Brokerage;

public class LndBrokerage extends Brokerage {

	public LndBrokerage(Broker broker) {
		this.subject = broker;
		this.subject.subscribe(this);
	}
	
	@Override
	public void update() {
		double stockUpdate = Math.round(2.2*subject.getstockPrice()*1000/1000);
		System.out.println("Hi LndBrokerage, new stockprice updated: " + stockUpdate + "£");
	}
}

package n1ex01.Observers;

import n1ex01.Broker;
import n1ex01.Brokerage;

public class TokioBrokerage extends Brokerage {

	public TokioBrokerage(Broker broker) {
		this.subject = broker;
		this.subject.subscribe(this);
	}
	
	@Override
	public void update() {		
		double stockUpdate = Math.round(1.6*subject.getstockPrice()*1000/1000);
		System.out.println("Hi TokioBrokerage, new stockprice updated: " + stockUpdate  + "¥");
	}
}

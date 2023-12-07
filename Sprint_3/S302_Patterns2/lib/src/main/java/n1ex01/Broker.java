package n1ex01;

import java.util.ArrayList;
import java.util.List;

// SUBJECT (OBSERVABLE)

public class Broker implements Observable {

	//list of observers to notify of any change in Subject's state
	private List<Brokerage> observers = new ArrayList<Brokerage>();
	//state of the subject
	private double stockPrice;
	
	public Broker() {
		this.observers = new ArrayList<Brokerage>();
		this.stockPrice = 2359.91d;
	}
	
	public double getstockPrice() {
		return this.stockPrice;
	}
	public void setstockPrice(double stockPrice) {
		this.stockPrice = stockPrice;
			notifyObservers();
	}
	
	// Methods observer can register/unregister themselves
	public void subscribe(Brokerage observer) {
		if(!observers.contains(observer)) {
			observers.add(observer);
		}
	}
	public void unsubscribe(Brokerage observer) {
		observers.remove(observer);
	}
	
	// Notify all observers of any change
	public void notifyObservers() {
		observers.forEach(o -> o.update());
	}
}

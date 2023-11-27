package n1ex01;

import java.util.ArrayList;

public class Undo {
	
	private static Undo undoInstance;
	private ArrayList<String> orders;
	private ArrayList<String> history;
	
	private Undo() {
		this.orders = new ArrayList<String>();
		this.history = new ArrayList<String>();
	}
	public static Undo getUndoInstance() {
		if(undoInstance == null) {
			undoInstance = new Undo();
		}
		return undoInstance;
	}
	
	
	//Grl methods
	public void saveLastOrders() {
		for(int i = 0; i < history.size(); i++) {
			orders.add(history.get(i));
		}
		System.out.println("Last orders saved successfully");
		history.clear();
	}
	public void addOrder(String order) {
		history.add(order);
		System.out.println("Order added successfully");
	}
	public void deleteOrder() {
		if(!orders.isEmpty()) {
			System.out.println("We're going to remove all the orders");
			orders.removeAll(orders);
			System.out.println("All orders deleted successfully");
		} else{
			System.out.println("There are no orders to remove");
		}
	}
	public void showLastSavedOrders() {
		
		if(!history.isEmpty()) {
			for(int i = 0; i < history.size(); i++) {
				System.out.println(history.get(i).toString());
			}
		} else {
			System.out.println("There are no saved orders to show");
		}
		
	}
	
}

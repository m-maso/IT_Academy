package provaNivell;

import java.util.ArrayList;
import java.util.List;

public class Buyer {

	List<Item> boughtItems;
	private String name;
	private String city;
	
	public Buyer(String name, String city) {
		this.boughtItems = new ArrayList<Item>();
		this.name = name;
		this.city = city;
	}
	
	public List<Item> getBoughtItems(){
		return this.boughtItems;
	}
	public String getName() {
		return this.name;
	}
	public String getCity() {
		return this.city;
	}
	
	public void setItems(List<Item> boughtItems) {
		this.boughtItems = boughtItems;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public void buyItem(Item item) {	
		boughtItems.add(item);
	}
}

package provaNivell;

import java.util.ArrayList;
import java.util.List;

public abstract class NPC {

	List<Item> items;
	private String name;
	private String city;
	private int MAX_ITEMS;
	private double TAX;
	
	public NPC(String name, String city) {
		this.name = name;
		this.city = city;
		this.items = new ArrayList<Item>();
	}
	
	public String getName() {
		return this.name;
	}
	public String getCity() {
		return this.city;
	}
	public List<Item> getItems(){
		return this.items;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	//methods
	public abstract void addItem(Item item) throws FullInventoryException;
}

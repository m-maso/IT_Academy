package provaNivell;

import java.util.ArrayList;
import java.util.List;

public abstract class NPC {

	protected List<Item> items;
	private String name;
	private String city;
	
	public NPC(String name, String city) {
		this.name = name;
		this.city = city;
		items = new ArrayList<Item>();
	}
	
	public String getName() {
		return this.name;
	}
	public String getCity() {
		return this.city;
	}
	public List<Item> getItems(){
		return items;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	//methods
	public abstract void addItem(Item item) throws FullInventoryException;
	
}

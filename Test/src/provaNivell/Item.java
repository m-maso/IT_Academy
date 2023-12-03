package provaNivell;

public class Item {

	private String name;
	private String type;
	private double price;
	private int wear;
	
	public Item(String name, String type, double price) {
		this.name = name;
		this.type = type;
		this.price = price;
	}
	
	public String getName() {
		return this.name;
	}
	public String getType() {
		return this.type;
	}
	public double getPrice() {
		return this.price;
	}
	public int wear() {
		return this.wear;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setWear(int wear) {
		this.wear = wear;
	}
	
	//method
	@Override
	public String toString() {
		return "Item: " + this.name + ", Type: " + this.type + ", Price: " + this.getPrice() + "£, Wear: " + this.wear + "%";
	}
	
	
}

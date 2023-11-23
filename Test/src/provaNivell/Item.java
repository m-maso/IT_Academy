package provaNivell;

public class Item {

	private String name;
	private String type;
	private double price;
	private double wearPerc;
	
	public Item(String name, String type, double price, double wearPerc) {
		this.name = name;
		this.type = type;
		this.price = price;
		this.wearPerc = wearPerc;
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
	public double wearPerc() {
		return this.wearPerc;
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
	public void setWearPerc(double wearPerc) {
		this.wearPerc = wearPerc;
	}
	
	
}

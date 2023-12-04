package n1ex01;

public class Product {
	
	// Attrib
	private String name;
	private float price;
	
	// Constr
	public Product(String name, float price) {
		this.name = name;
		this.price = price;
	}
	
	// Getters
	public String getName() {
		return this.name;
	}
	public float getPrice() {
		return this.price;
	}
	
	// Setters
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	// Methods
	@Override
	public String toString() {
		return "Product: " + this.name + "\nPrice: " + this.price;
	}
}

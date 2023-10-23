package n3ex04;

public class Bag {

	// Attrib
	private String brand;
	private String colour;
	
	// Constr
	public Bag(String brand, String colour) {
		this.brand = brand;
		this.colour = colour;
	}
	
	// Getters
	public String getBrand() {
		return this.brand;
	}
	public String getColour() {
		return this.colour;
	}
	
	// Setters
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	
	// Own Method
	@Override
	public String toString() {
		return "Bag -> Brand: " + this.brand + ", Colour: " + this.colour;
	}

}

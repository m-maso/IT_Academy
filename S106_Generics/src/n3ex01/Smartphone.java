package n3ex01;

public class Smartphone implements Phone {

	// Attrib
	private String brand;
	private String model; 
	
	// Constr
	public Smartphone(String brand, String model) {
		this.brand = brand;
		this.model = model;
	}
	
	// Getters
	public String getBrand() {
		return this.brand;
	}
	public String getModel() {
		return this.model;
	}
	
	// Setters
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	// Grl Methods
	public void takePhoto() {
		System.out.println("Taking a photo...");
	}
	@Override
	public void call() {
		System.out.println("Calling to... ");
	}

}

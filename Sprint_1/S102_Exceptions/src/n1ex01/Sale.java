package n1ex01;

import java.util.ArrayList;

public class Sale {

	// Attrib
	static ArrayList<Product> products; // products' collection
	private float totalSalePrice;
	
	// Constr
	public Sale() {
		Sale.products = new ArrayList<Product>();
		this.totalSalePrice = 0.0f;
	}
	
	// Getters
	public ArrayList<Product> getProducts() {
		return products;
	}
	public float getTotalSalePrice() {
		return this.totalSalePrice;
	}
	
	// Setters
	public void setProducts(Product product) {
		Sale.products.add(product);
	}

	public void setTotalSalePrice(float totalSalePrice) {
		this.totalSalePrice = totalSalePrice;
	}
	
		
	// Grl Method
	public void calculateTotal() throws EmptySaleException {
		
		if(products.isEmpty()) { 
			throw new EmptySaleException("Your sale is empty! Please add some products");
		} else {	
			for(int i = 0; i < products.size(); i++) {
				totalSalePrice += products.get(i).getPrice();
			}
			System.out.println("Total price: " + totalSalePrice + "€.");
		}
	}
	public void printProducts() throws ArrayIndexOutOfBoundsException {
		if(products.size() > 2) {
			throw new ArrayIndexOutOfBoundsException("You can only add 2 items per sale");
		}
	}
	
	// Own Method
	@Override
	public String toString() {
		return "Sale-> Products:\n" + products;
	}
}


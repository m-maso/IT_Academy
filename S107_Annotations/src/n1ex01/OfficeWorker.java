package n1ex01;

public class OfficeWorker extends Worker {

	// Attrib
	private static float gasPrice = 50;
	
	// Constr
	public OfficeWorker(String firstN, String lastN, float priceHour) {
		super(firstN, lastN, priceHour);
	} 
	
	// Getter
	public static float getGasPrice() {
		return gasPrice;
	}
	
	// Setter
	public static void setGasPrice(float gasPrice) {
		OfficeWorker.gasPrice = gasPrice;
	}
	
	// Grl Method
	@Override
	public void calcSalary(float monthlyHours) {
		float salary = 0;
		salary = (monthlyHours * super.getPriceHour()) + gasPrice;
		System.out.println("The office worker's salary is: " + salary + " €.");
	}
}

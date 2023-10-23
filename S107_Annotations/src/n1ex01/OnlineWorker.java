package n1ex01;

public class OnlineWorker extends Worker {

	// Attrib
	private final int INTERNETBILL = 35;
	
	// Constr
	public OnlineWorker(String firstN, String lastN, float priceHour) {
		super(firstN, lastN, priceHour);
	}
	
	// Getter
	public int getINTERNETBILL() {
		return this.INTERNETBILL;
	}
	
	// Grl Method
	@Override
	public void calcSalary(float monthlyHours) {
		float salary = 0;
		salary = (monthlyHours * super.getPriceHour()) + this.INTERNETBILL;
		System.out.println("The online worker's salary is: " + salary + " €.");
	}
}

package n1ex02;

public class Worker {

	// Attrib
		private String firstN;
		private String lastN;
		private float priceHour;
		
		// Constr
		public Worker(String firstN, String lastN, float priceHour) {
			this.firstN = firstN;
			this.lastN = lastN;
			this.priceHour = priceHour;
		}
		
		// Getters
		public String getFirstN() {
			return this.firstN;
		}
		public String getLastN() {
			return this.lastN;
		}
		public float getPriceHour() {
			return this.priceHour;
		}
		
		// Setters
		public void setFirstN(String firstN) {
			this.firstN = firstN;
		}
		public void setLastN(String lastN) {
			this.lastN = lastN;
		}
		public void setPriceHour(float priceHour) {
			this.priceHour = priceHour;
		}
		
		// Grl Method
		public void calcSalary(float monthlyHours) {
			float salary = 0;
			salary = monthlyHours * this.priceHour;
			System.out.println("The worker's salary is: " + salary + "€.");
		}
		
		// Own Method
		@Override
		public String toString() {
			return "Worker: " + this.firstN + " " + this.lastN + " works for " + this.priceHour + "€/h.";
		}
}

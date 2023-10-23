package n1ex01;

import java.util.ArrayList;

public class Months {

		// Create ordered list and insert the months of the year
		private ArrayList<String> months = new ArrayList<String>();
		
		public Months() {
			months.add("January");
			months.add("February");
			months.add("March");
			months.add("April");
			months.add("May");
			months.add("June");
			months.add("July");
			months.add("August");
			months.add("September");
			months.add("October");
			months.add("November");
			months.add("December");
		}
		
		public ArrayList<String> getMonths(){
			return this.months;
		}
		public void setMonths(ArrayList<String> months) {
			this.months = months;
		}
		
}

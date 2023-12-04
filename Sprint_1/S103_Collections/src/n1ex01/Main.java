package n1ex01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		
			ArrayList<Month> months = new ArrayList<Month>();
			
			months.add(new Month("January"));
			months.add(new Month("February"));
			months.add(new Month("March"));
			months.add(new Month("April"));
			months.add(new Month("May"));
			months.add(new Month("June"));
			months.add(new Month("July"));
			months.add(new Month("September"));
			months.add(new Month("October"));
			months.add(new Month("November"));
			months.add(new Month("December"));
			
			// Add Month object (August) in its right place
			months.add(7, new Month("August"));
			
			System.out.println("ArrayList of month objects (for loop)");
			for(Month month : months) {
				System.out.println(month.toString());
			}
			
			
			//pass arraylist object into hashset
			/*another option(HashSet ): 
			 * HashSet<Month> monthshs = new HashSet<Month>(months);*/
//			Set<Month> monthshs = new HashSet<Month>();
				// Using LinkedHashSet instead of HashSet to show months in right order
			Set<Month> monthshs = new LinkedHashSet<Month>();  	
			monthshs.addAll(months);
			
			// Create duplicates to check
			monthshs.add(new Month("January"));
			monthshs.add(new Month("May"));
			
			System.out.println("\nLoop through HashSet of month objects (for loop)");
			for(Month month : monthshs) {
				System.out.println(month.getName());
			}
		
			System.out.println("\nIterate HashSet of month objects (iterator)");
			Iterator<Month> monthshsIt = monthshs.iterator();
			
			while(monthshsIt.hasNext()) {
				System.out.println(monthshsIt.next().getName());
			}

	}

}

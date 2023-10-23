package n2ex04;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		List<Object> strAndnum = Arrays.asList(1,"hello","e-mail",72,"birthday","3","ann",22,"end", "2", "how are you", 344, 1222, "travelling", "month");
	
		System.out.println("List of strings and numbers ordered by 1st char.(1-9,A-Z):");
		strAndnum.stream().sorted(Comparator.comparing(str -> str.toString().charAt(0)))
						  .forEach(System.out::println);
		
		System.out.println("\nOrder of the list-> strings starting with 'e' 1st and then rest of the strings:");
		strAndnum.stream().filter(str -> str.toString().startsWith("e")) 
						  .forEach(str -> System.out.println(str));
		strAndnum.stream().filter(str -> !str.toString().startsWith("e"))
						  .forEach(System.out::println);
		
		System.out.println("\nModify strings: change 'a' to '4'");
		strAndnum.stream().map(str -> str.toString().replace('a', '4'))
						  .forEach(System.out::println);
						
		System.out.println("\nShowing numbers only (as int and str types):");
		/* Show only integers type
		 strAndnum.stream().filter(str -> str instanceof Integer)
						  .forEach(System.out::println); 
		*/
		strAndnum.stream().filter(str -> str.toString().chars().allMatch(Character::isDigit))
						  .forEach(System.out::println);
	}

}
package n1ex06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	
	public static void main(String[] args) {
		/* Order the list by string length (short to long) */
		
		List<Object> numsAndStrs = Arrays.asList(1,"hello","Ann",22, "howareyou", 344, 1222, "travelling", "month");
		
		List<Object> orderedList = new ArrayList<Object>();
		orderedList = numsAndStrs.stream()
							.sorted(Comparator.comparing(obj -> obj.toString().length()))
							.collect(Collectors.toList());
		
		System.out.println("List of numbers and strings ordered by length (short to long): \n" + orderedList);

	}
}

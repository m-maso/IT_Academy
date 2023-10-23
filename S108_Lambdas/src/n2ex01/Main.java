package n2ex01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		/* Create a list and a method */
		// Create a list of names of people
		List<String> namesList = Arrays.asList("John","Ann","Mark","Alex","Mary","Ana","andrew","Aubrey","Simon");
		System.out.println(strFilter(namesList));
		
		
	}
	/** Method that returns a list of all the strings that:
	 * - start with capital letter 'A' and
	 * - have exactly 3 letters 
	 * Print the result */
	public static List<String> strFilter(List<String> namesList) {
		List<String> filteredList = new ArrayList<String>();
		filteredList = namesList.stream().filter(str -> str.startsWith("A") && str.length()==3)
										 .collect(Collectors.toList());
		return filteredList;
	}
}

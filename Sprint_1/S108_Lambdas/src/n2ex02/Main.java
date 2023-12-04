package n2ex02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		
		List<Integer> intList = new ArrayList<Integer>();
		intList.addAll(Arrays.asList(3, 55, 44, 2));
		System.out.println(customiseList(intList));
	}

	/** Method that returns a string separate by ',' based in a list of integers.
	 *  Preceded by letter "e" if number is even, or letter "o" if the number is odd
	 * 	Print the result
	 * */
	/* String res = (num % 2 == 0) ? ("e" + num a str) : ("o" + num a str);
	 * Stream map(Function mapper) returns a stream consisting of the results of applying 
	 * the given function to the elements of this stream.*/
	
	public static String customiseList(List<Integer> intList) {
		String customizedList;
		customizedList = intList.stream()
							.map(num -> num % 2 == 0 ? "e" + num.toString() : "o" + num.toString())
							.collect(Collectors.joining(", "));
		
		return customizedList;
	}
}

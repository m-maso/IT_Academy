package n1ex01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		List<String> strList = new ArrayList<String>();
		strList.addAll(Arrays.asList("Hello","How", "are","you","add","all","strings","Old"));

		/* Printing words directly, without a previous saved list */
		strList.stream().filter(word->word.toLowerCase().contains("o"))
						.forEach(word->System.out.println(word));

	}
}

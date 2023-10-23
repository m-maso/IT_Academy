package n1ex01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {

		List<String> strList = new ArrayList<String>();
		strList.addAll(Arrays.asList("Hello","How", "are","you","add","all","strings","Old"));
		
//		strList.forEach(word->System.out.println(word));

		/* Printing words directly */
		strList.stream().filter(word->word.contains("o") || word.contains("O"))
						.forEach(word->System.out.println(word));
		
		/* Printing words from a previous saved list */
		
		List<String> wordsWithO = new ArrayList<String>();
		wordsWithO = strList.stream()
						.filter(word->word.contains("o") || word.contains("O"))
						.collect(Collectors.toList());
		System.out.println("Printing words from a previous saved list" + wordsWithO);
	}
}

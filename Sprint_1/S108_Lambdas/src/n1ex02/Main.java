package n1ex02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		List<String> strList = new ArrayList<String>();
		strList.addAll(Arrays.asList("Halloween","How to", "are","you","add","all","strings","Old"));
		
//		strList.forEach(word->System.out.println(word));
		
		strList.stream().filter(word->(word.contains("o") || word.contains("O")) && (word.length() > 5))
						.forEach(System.out::println);

	}

}

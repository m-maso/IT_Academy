package n2ex02;

import java.util.Arrays;
import java.util.List;

public class Main {

public static void main(String[] args) {
		
		Person pers1 = new Person("Maria","Pau",34);
		Person pers2 = new Person("Pol","Sau", 22);
		Person pers3 = new Person("Marià","Soca", 78);
		String word1 = "Test";
		String word2 = "Hello";
		String word3 = "World";
		Integer num1 = 167;
		Integer num2 = 16;
		Integer num3 = 67;
		
		
		List<Object> list = Arrays.asList(pers1,word1,num1,word2,num2,pers2,num3,pers3,word3);
		GenericMethods.printArgs(list);
	}

}

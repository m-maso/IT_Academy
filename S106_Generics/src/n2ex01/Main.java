package n2ex01;


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
		
	/* Previous ex.	
		// Calling generic method with object class Person, String, primitive
		GenericMethods.printArgs(pers1, word1, num1);
		GenericMethods.printArgs(word2, num2, pers2);
		GenericMethods.printArgs(num3, pers3, word3);
	*/
		
		// Calling generic method with 1 arg String and 2 generics
		GenericMethods.printArgs(word1, pers1, num1);
		GenericMethods.printArgs(word2, word3, pers2);
		GenericMethods.printArgs(word3, num2, word2);
		GenericMethods.printArgs(word1, pers3, num3);
	}

}

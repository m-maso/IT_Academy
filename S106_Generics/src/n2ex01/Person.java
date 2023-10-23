package n2ex01;

public class Person {

	// Attrib
	private String firstN;
	private String lastN;
	private int age;
	
	// Constr
	public Person(String firstN, String lastN, int age) {
		this.firstN = firstN;
		this.lastN = lastN;
		this.age = age;
	}
	
	// Getters
	public String getFirstN() {
		return this.firstN;
	}
	public String getLastN() {
		return this.lastN;
	}
	public int getAge() {
		return this.age;
	}
	
	// Setters
	public void setFirstN(String firstN) {
		this.firstN = firstN;
	}
	public void setLastN(String lastN) {
		this.lastN = lastN;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	// Own method
	@Override
	public String toString() {
		return "Person: " + firstN + " " + lastN + " is " + age + " years old";
	}
}

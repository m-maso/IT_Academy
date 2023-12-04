package n3ex01;

public class Student {

	// Attrib
	private String name;
	private int age;
	private String subject;
	private float mark;
	
	// Constr
	public Student(String name, int age, String subject, float mark) {
		this.name = name;
		this.age = age;
		this.subject = subject;
		this.mark = mark;
	}
	
	// Getters
	public String getName() {
		return this.name;
	}
	public int getAge() {
		return this.age;
	}
	public String getSubject() {
		return this.subject;
	}
	public float getMark() {
		return this.mark;
	}
	
	// Setters
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setMark(float mark) {
		this.mark = mark;
	}
	
	// Own Method
	public String toString() {
		return "Name: " + this.name + ", Age: " + this.age + ", Subject: " 
				+ this.subject + ", Mark: " + this.mark;
	}
	
}

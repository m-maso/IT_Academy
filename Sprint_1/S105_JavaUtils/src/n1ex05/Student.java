package n1ex05;

 /* If a class implements Serializable interface means it can be serialized */
public class Student implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Attrib
	private String firstN;
	private String lastN;
	private int age;
	private String subject;
	
	// Constr
	public Student(String firstN, String lastN, int age, String subject) {
		this.firstN = firstN;
		this.lastN = lastN;
		this.age = age;
		this.subject = subject;
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
	public String getSubject() {
		return this.subject;
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
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	// Own Method
	@Override
	public String toString() {
		return "Student: " + firstN + " " + lastN + " is studying "
				 + subject + " and is " + age + " years old."; 
	}
}

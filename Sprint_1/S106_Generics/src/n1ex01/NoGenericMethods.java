package n1ex01;

public class NoGenericMethods {

	// Attrib
	private String object1;
	private String object2;
	private String object3;
	
	// Constr
	public NoGenericMethods(String object1, String object2, String object3) {
		this.object1 = object1;
		this.object2 = object2;
		this.object3 = object3;
	}
	
	// Getters
	public String getObject1() {
		return this.object1;
	}
	public String getObject2() {
		return this.object2;
	}
	public String getObject3() {
		return this.object3;
	}
	
	// Setters
	public void setObject1(String object1) {
		this.object1 = object1;
	}
	public void setObject2(String object2) {
		this.object2 = object2;
	}
	public void setObject3(String object3) {
		this.object3 = object3;
	}
	
	// Grls Methods
	public void print() {
		System.out.println(object1);
		System.out.println(object2);
		System.out.println(object3);
	}

}

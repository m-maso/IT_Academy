package n1ex01;

public class NoGenericMethods <T> {

	// Attrib
	private T object1;
	private T object2;
	private T object3;
	
	// Constr
	public NoGenericMethods(T object1, T object2, T object3) {
		this.object1 = object1;
		this.object2 = object2;
		this.object3 = object3;
	}
	
	// Getters
	public T getObject1() {
		return this.object1;
	}
	public T getObject2() {
		return this.object2;
	}
	public T getObject3() {
		return this.object3;
	}
	
	// Setters
	public void setObject1(T object1) {
		this.object1 = object1;
	}
	public void setObject2(T object2) {
		this.object2 = object2;
	}
	public void setObject3(T object3) {
		this.object3 = object3;
	}
	
	// Grls Methods
	public void print() {
		System.out.println(object1);
		System.out.println(object2);
		System.out.println(object3);
	}

}

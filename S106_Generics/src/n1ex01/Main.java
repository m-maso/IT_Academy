package n1ex01;

public class Main {

	public static void main(String[] args) {
		
		int object1 = 3;
		String object2 = "Hello";
		boolean object3 = true;
		
		System.out.println("Ordered objects");
		NoGenericMethods<Object> objAsc = new NoGenericMethods<>(object1, object2, object3);
		objAsc.print();
		System.out.println("\nMisordered objects");
		NoGenericMethods<Object> objDesc = new NoGenericMethods<>(object3, object2, object1);
		objDesc.print();
		System.out.println("\nMix objects up");
		NoGenericMethods<Object> mixedUp = new NoGenericMethods<>(object2, object3, object2);
		mixedUp.print();
	}

}

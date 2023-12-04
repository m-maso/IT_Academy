package n1ex01;

public class Main {

	public static void main(String[] args) {
		
		String object1 = "Java";
		String object2 = "PHP";
		String object3 = "JS";
		
		System.out.println("Print ordered objects asc.");
		NoGenericMethods objAsc = new NoGenericMethods(object1, object2, object3);
		objAsc.print();
		System.out.println("\nPrint ordered objects desc.");
		NoGenericMethods objDesc = new NoGenericMethods(object3, object2, object1);
		objDesc.print();
		System.out.println("\nPrint objects mixed up");
		NoGenericMethods mixedUp = new NoGenericMethods(object2, object3, object1);
		mixedUp.print();
	}

}

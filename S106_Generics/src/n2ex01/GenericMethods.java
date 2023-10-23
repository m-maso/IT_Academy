package n2ex01;

public class GenericMethods {
	/* Previous ex.
	public static <T> void printArgs(T arg1, T arg2, T arg3) {
		System.out.println("Arg. 1: " + arg1 + ",\n"
				+ " Arg.2: " + arg2 + ",\n"
				+ " Arg.3: " + arg3);
	}
	*/
	// Create a generic method with one argument non generic
	public static <T> void printArgs(String arg1, T arg2, T arg3) {
		System.out.println("Arg. 1: " + arg1 + ",\n"
				+ " Arg.2: " + arg2 + ",\n"
				+ " Arg.3: " + arg3);
	}
}
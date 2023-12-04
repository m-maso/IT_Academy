package n1ex02;

public class GenericMethods  {

	public static <T> void printArgs(T arg1, T arg2, T arg3) {
		System.out.println("Arg. 1: " + arg1 + ",\n"
				+ " Arg.2: " + arg2 + ",\n"
				+ " Arg.3: " + arg3);
	}
}

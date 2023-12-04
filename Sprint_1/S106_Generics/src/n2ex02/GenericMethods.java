package n2ex02;

import java.util.List;

public class GenericMethods {
	/* Previous
	public static <T> void printArgs(T arg1, T arg2, T arg3) {
		System.out.println("Arg. 1: " + arg1 + ",\n"
				+ " Arg.2: " + arg2 + ",\n"
				+ " Arg.3: " + arg3);
	}
	*/
	
	// Method args. have to be a list of args. 
	public static void printArgs(List<?> list) {
		for(Object obj : list) {
			System.out.println(obj.toString());
		}
	}
}
//Modifica l'apartat anterior de manera que els arguments del mètode 
//genèric siguin una llista d'arguments de variable indefinida.
package n1ex01;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Directory {
	
	public static void main(String[] args) {
	
//	String dirPath = "C:\\Users\\monma\\Documents\\IT Academy\\espc_java";
		Scanner sc = new Scanner(System.in);
		String path = "args[0]";

		if(args.length != 1) {
			System.out.println("Write the path of the directory you want to list");
			path = sc.nextLine();
		}
		listDirSorted(path);
		sc.close();
	}
	
	public static void listDirSorted(String path) {
		File dirFolder = new File(path);
		
		// Check if directory exists
		if(dirFolder.exists()) {
			System.out.println("Directory's content sorted: ");
			Arrays.stream(dirFolder.listFiles()).forEach(System.out::println); 
		} 
		else {
			System.out.println("There's no directory in this path");
		}
	}
}
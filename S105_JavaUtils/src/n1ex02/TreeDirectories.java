package n1ex02;

import java.io.File;
import java.sql.Date;
import java.util.Arrays;
import java.util.Scanner;

public class TreeDirectories {

	public static void main(String[] args) {
		
//		String dirPath = "C:\\Users\\monma\\Documents\\IT Academy\\espc_java\\Sprint_1\\S1_05\\src";
		Scanner sc = new Scanner(System.in);
		String path = "args[0]";

		if(args.length != 1) {
			System.out.println("Write the path of the directory you want to list");
			path = sc.nextLine();
		}
		
		System.out.println("Directory's content sorted: ");
		listDirTreeRecur(path);

		sc.close();
	}
	
	
	public static void listDirTreeRecur(String path) {
		File dirFolder = new File(path);

		// Check if directory exists
		if(dirFolder.exists()) {
			File[] dirFiles = dirFolder.listFiles();
			Arrays.sort(dirFiles);
			
			for(File file : dirFiles) {
				Date date = new Date(file.lastModified());
				
				/* If 'file' is dir show D, if it's type file show F
				and last modified date */
				if(file.isDirectory()) { 
					System.out.println("|__(D) " + date.toString() + " " + file.getName());
					// Printing recursively
					String subPath = file.getAbsolutePath();
					listDirTreeRecur(subPath);
//					System.out.println(" |-Subdirectory");
				} else {
					System.out.println("  |____(F) " + date.toString() + " " + file.getName());
				}	
			}
		} 
		else {
			System.out.println("There's no directory in this path");
		}
	}
	

}

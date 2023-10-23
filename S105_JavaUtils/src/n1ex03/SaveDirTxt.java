package n1ex03;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;
import java.util.Scanner;

public class SaveDirTxt {

	public static void main(String[] args) {
		
//		String dirPath = "C:\\Users\\monma\\Documents\\IT Academy\\espc_java\\Sprint_1\\S1_05\\src";
		Scanner sc = new Scanner(System.in);
		String path = "args[0]";

		if(args.length != 1) {
			System.out.println("Write the path of the directory you want to list");
			path = sc.nextLine();
		}
		
		listDirTreeRecur(path);

		System.out.println("You can see the Tree Directories file 'TreeDirectories.txt'");
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
					saveTreeDirFile("|__(D) " + date.toString() + " " + file.getName());
				// Printing recursively
					String subPath = file.getAbsolutePath();
					listDirTreeRecur(subPath);
				} else {
					saveTreeDirFile("  |____(F) " + date.toString() + " " + file.getName());
				}	
			}
		} 
		else {
			System.out.println("There's no directory in this path");
		}
	}
	
	/**
	 * Saving Tree Directories into a text file
	 * @param String strCL -> lines that we were printing in the last exer. */

	public static void saveTreeDirFile(String strCL) {
//		String path = "C:\\Users\\monma\\Documents\\IT Academy\\espc_java\\Sprint_1\\S1_05\\src\\n1ex03\\TreeDirectories.txt";
		try {
//			File newFile = new File(path);
			File newFile = new File("TreeDirectories.txt");
		
			if(!newFile.exists()) {
				newFile.createNewFile();
				System.out.println("New Tree Directories File Created");
			} 
			
			FileWriter writting = new FileWriter(newFile, true);
			writting.write(strCL);
			writting.write(" \n");
			writting.close();
			
		} catch(IOException e) {
			System.out.println("There has been an error" + e.getMessage());
//			e.printStackTrace();
		}
		
	}
	
}
package n1ex04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;
import java.util.Scanner;

public class ReadTxtShowContent {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
//		String dirPath = "C:\\Users\\monma\\Documents\\IT Academy\\espc_java\\Sprint_1\\S1_05\\src";
		
		String path = "args[0]";
		

		if(args.length != 1) {
			System.out.println("Write the path of the directory you want to list");
			path = sc.nextLine();
		}
		
		
		listDirTreeRecur(path);
		System.out.println("You can see the Tree Directories file 'TreeDirectories.txt'");
		
		/* Adding a new functionality so user can read any .txt file and
		 * then show its content in the console. */ 
		
		System.out.println("\nWrite the path where the file you want to read is located");
		String pathForRead = sc.nextLine();
//		pathForRead = "C:\\Users\\monma\\Documents\\IT Academy\\espc_java\\Sprint_1\\S1_03\\src\\n1ex03\\score.txt";
		
		readFileShowContent(pathForRead);
		sc.close();	
	}
	
	public static void listDirTreeRecur(String path) {
		File dirFolder = new File(path);

		if(dirFolder.exists()) {
			File[] dirFiles = dirFolder.listFiles();
			Arrays.sort(dirFiles);
			
			for(File file : dirFiles) {
				Date date = new Date(file.lastModified());
				
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
		String path = "C:\\Users\\monma\\Documents\\IT Academy\\espc_java\\Sprint_1\\S1_05\\src\\n1ex03\\TreeDirectories.txt";
		try {
			File newFile = new File(path);
//			File myNewFile = new File("TreeDirectories.txt");
		
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
	
	
	/** New Functionality
	 * Read a file and show content to console:
	 * @param String pathForRead -> give it by user input
	*/
	public static void readFileShowContent(String pathForRead) { 
		
		String strCL = ""; //String Current Line
		
		try {
			File file = new File(pathForRead);
			
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			while((strCL = br.readLine()) != null) {
				if(strCL != null && !strCL.isEmpty()){
					System.out.println(strCL);
				}
			}
			br.close();
		} catch (FileNotFoundException e) {  // new FileReader()
			System.out.println("Error! File not found " + e.getMessage());			
//			e.printStackTrace();
		}
		catch (IOException e) {  //  br.readLine()
			System.out.println("Input/Output error " + e.getMessage());
//			e.printStackTrace();
		} 
	}

}

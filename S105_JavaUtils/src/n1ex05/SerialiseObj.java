package n1ex05;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class SerialiseObj {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String path = "args[0]";
		if(args.length != 1) {
			System.out.println("Write the path of the directory you want to save the file");
			path = sc.nextLine();
		}
		// Class is writting an obj of Student class to the 'SerialiseObj.ser' file
		Student[] students = new Student[2];
		students [0] = new Student("George","White",25,"Java");
		students [1] = new Student("John","Mason",51,"JavaScript");
		
//		File dirFolder = new File(path);
//		if(dirFolder.exists()) {
//			serialiseOject(students, path);
//			deserialiseObject(path); 
//		} 
//		else {
//			System.out.println("There's no directory in this path");
//		}
		serialiseOject(students, path);
		deserialiseObject();
		
//		serialiseOject(students, args[0]);
//		deserialiseObject(args[0]);
		sc.close();
	}		

	
	public static void serialiseOject(Student[] students, String path){
		
		try {
//			FileOutputStream fileOut = new FileOutputStream("C:\\Users\\monma\\Documents\\IT Academy\\espc_java\\Sprint_1\\S1_05\\src\\n1ex05\\SerialiseObj.ser");
			FileOutputStream fileOut = new FileOutputStream("SerialiseObj.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(students);
			out.close();
			fileOut.close();
			System.out.println("Serialised data is saved in 'SerialiseObj.ser' file");
			
		} catch (FileNotFoundException e) { // new FileOutputStream()
			System.out.println("Error, File not found"  + e.getMessage());
			e.printStackTrace();	 
		} catch (IOException e) { // new ObjectOutputStream()
			System.out.println("I/O Error"  + e.getMessage());
			e.printStackTrace();
		}
		
		
	}
	
	
	public static void deserialiseObject() {
		
//		Student[] studentsSerial = null;
		
		try {
//			FileInputStream fileIn = new FileInputStream("C:\\Users\\monma\\Documents\\IT Academy\\espc_java\\Sprint_1\\S1_05\\src\\n1ex05\\SerialiseObj.ser");
			FileInputStream fileIn = new FileInputStream("SerialiseObj.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			Student[] studentsSerial = (Student[])in.readObject();  
			System.out.println("\nDeserialising Students..");
			for(Student studentSer : studentsSerial) {
				System.out.println(studentSer.toString());
			}
			in.close();
			fileIn.close();
		} catch (FileNotFoundException e) { // new FileOutputStream()
			System.out.println("Error, File not found"  + e.getMessage());
//			e.printStackTrace();	 
		} catch (IOException e) { // new ObjectOutputStream()
			System.out.println("I/O Error"  + e.getMessage());
//			e.printStackTrace();
		} catch (ClassNotFoundException e) { //readObject()
			System.out.println("Error, Class not found"  + e.getMessage());
//			e.printStackTrace();
		} 
	}
}

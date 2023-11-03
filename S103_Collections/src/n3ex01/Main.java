package n3ex01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	static ArrayList<Person> people = new ArrayList<Person>();
	
	public static void main(String[] args) {
		
		// Calling to read .csv file
		people = readCSVFile();
		
		int option = 0;
		String msg = "";
		Scanner sc = new Scanner(System.in);
		String firstN, lastN, nif;
		
		do {
			System.out.println("MENU\n"
					+ "1.- New person\n"
					+ "2.- Show people sorted by first name (A-Z)\n"
					+ "3.- Show people sorted by first name (Z-A)\n"
					+ "4.- Show people sorted by last name (A-Z)\n"
					+ "5.- Show people sorted by last name (Z-A)\n"
					+ "6.- Show people sorted by DNI (1-9)\n"
					+ "7.- Show people sorted by DNI (9-1)\n"
					+ "0.- Exit");
			
			option = sc.nextInt();
			sc.nextLine();
			
			switch(option) {
			case 0: 
				msg = "You're leaving the app";
				break;
			case 1:
				System.out.println("Enters a person, answer the following questions.\n"
						+ "Enter your first name");
				firstN = sc.nextLine();
				System.out.println("Enter your last name");
				lastN = sc.nextLine();
				System.out.println("Enter your nif");
				nif = sc.nextLine();
				people.add(new Person(firstN,lastN,nif));
				break;
			case 2:
				System.out.println("People sorted by first name (A-Z):\n");
				Collections.sort(people, Person.Comparators.FirstName);
				printPeople();
				break;
			case 3:
				System.out.println("People sorted by first name (Z-A):\n");
				Collections.sort(people, Person.Comparators.FirstName.reversed());
				printPeople();
				break;
			case 4:
				System.out.println("People sorted by first last name (A-Z):\n");
				Collections.sort(people, Person.Comparators.LastName);
				printPeople();
				break;
			case 5:
				System.out.println("People sorted by first last name (Z-A):\n");
				Collections.sort(people, Person.Comparators.LastName.reversed());
				printPeople();
				break;
			case 6:
				System.out.println("People sorted by NIF (1-9):\n");
				Collections.sort(people, Person.Comparators.Nif);
				printPeople();
				break;
			case 7:
				System.out.println("People sorted by NIF (9-1):\n");
				Collections.sort(people, Person.Comparators.Nif.reversed());
				printPeople();
				break;
			default:
				msg = "Error! Choose one number between 0 and 7";
			}
			
			System.out.println(msg);
			
		} while(option != 0);
		sc.close();
	}	
	
	/** Read the .csv file
	 * It reads the file line by line, .split it gives each cell and the data it's saved in an ArrayList<Person>
	 * @return an ArrayList<Person> people */ 
	
	public static ArrayList<Person> readCSVFile() {
		String line = "";
		String firstN, lastN, nif;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("./src/people.csv"));
			while((line = br.readLine()) != null) {
				String[] values = line.split(",");
				firstN = values[0];
				lastN = values[1];
				nif = values[2];
				people.add(new Person(firstN,lastN,nif));
			}
			br.close();
		} catch (FileNotFoundException e) {  
			System.out.println("Error! File not found " + e.getMessage());			
		} catch (IOException e) { 
			System.out.println("Input/Output error " + e.getMessage());
		} 
		return people;
	}
	
	/** Print list */
	public static void printPeople() {
		for(Person person : people) {
			System.out.println(person.toString());
		}
	}
	
}
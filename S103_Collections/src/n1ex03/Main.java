package n1ex03;

/** JOC
 * Es tracta de què l’usuari/ària ha d’escriure el nom de la capital del país en qüestió. 
 * Si l’encerta se li suma un punt. Aquesta acció es repeteix 10 vegades. 
 * Un cop demanades les capitals de 10 països de forma aleatòria, 
 * llavors s’ha de guardar en un fitxer anomenat classificacio.txt, 
 * el nom de l’usuari/ària i la seva puntuació.  */ 

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		String userName = "";
		String capital = "";
		String country = "";
		String userCapital = "";
		int score = 0;
		Scanner sc = new Scanner(System.in);
		

		//Read the file and save the data into a HashMap<String, String>
				// Saved into a LinkedHashMap to show the countries alphabetically
		HashMap<String, String> countriesHMap = new LinkedHashMap<String, String>();
		countriesHMap = readFile(countriesHMap);

		
		/* GAME */
		System.out.println("Write your name:");
		userName = sc.nextLine();
		
		for(int i = 0; i < 10; i++) {
			int numRandom = (int)(Math.random()*(countriesHMap.size()));
			country = (String) countriesHMap.keySet().toArray()[numRandom];
			capital = (String) countriesHMap.values().toArray()[numRandom];
			
			System.out.println("Which is the capital of " + country + "?");
			userCapital = sc.nextLine();
			
			if(userCapital.equalsIgnoreCase(capital)) {
				System.out.println("Well done " + userName + "! You gain 1 point\n");
				score++;
			} else {
				System.out.println("You're mistaken! The capital is " + capital + "\n");
			}
		}

		System.out.println("You finished the game, " + userName + "!");
		
		
		saveInScoreFile(userName, score);
		System.out.println("You can see your total score in the 'score.txt' file");
		sc.close();
	}
	
	/**
	 * Read a file:
	 * Read 'countries.txt' line by line, split each line in 2 cells into an array
	 * add each element of the arrays inside the HashMap<String, String> I return
	*/
	public static HashMap<String, String> readFile(HashMap<String, String> countriesHMap) { 

		String strCL = ""; 
		String country, capital;
		try {
			File file = new File("./src/n1ex03/countries.txt");  
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			while((strCL = br.readLine()) != null) {
				if(strCL != null && !strCL.isEmpty()){
					
					String cell[] = strCL.split(" ");
					
					if(!cell[0].isEmpty() && !cell[1].isEmpty()) {
						country = cell[0].replace("_", " ");
						capital = cell[1].replace("_", " ");
						countriesHMap.put(country, capital);
					}
				}
			}
			br.close();
		} catch (FileNotFoundException e) {  
			System.out.println("Error! File not found " + e.getMessage());			
		}
		catch (IOException e) {  
			System.out.println("Input/Output error " + e.getMessage());
		} 
		return countriesHMap;
	}
	
	/**
	 * Save data into a .txt file: We save 'userName' and 'score' 
	 * */
	public static void saveInScoreFile(String userName, int score) {

		try {

			File myNewFile = new File("./src/n1ex03/score.txt");
		
			if(!myNewFile.exists()) {
				myNewFile.createNewFile();
				System.out.println("New Score File Created");
			} 
			
			FileWriter writting = new FileWriter(myNewFile, true);
			writting.write("Username: " + userName + ", Score: " + score + " points");
			writting.write("\n");
			writting.close();
			
		} catch(IOException e) {
			System.out.println("There has been an error" + e.getMessage());
		}
		
	}
	
}
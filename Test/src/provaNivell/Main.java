package provaNivell;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	
	static List<NPC> sellers = new ArrayList<NPC>();  
	static List<Buyer> buyers = new ArrayList<Buyer>();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		int option = 0;
		String name = "";
		String city = "";
		
		String seller = "";
		String buyer = "";
		int indexSeller = "";
		int indexBuyer = "";
		
		
		do {
			System.out.println("NPCs APP MENU\n"
					+ "1. Create a seller\n"
					+ "2. Add item to seller's inventory\n"
					+ "3. Show the cheapest item of all sellers of one city\n"
					+ "4. Show items of one seller\n"
					+ "5. Create a buyer\n"
					+ "6. Buy one item\n"
					+ "7. Show items of one buyer\n"
					+ "8. Show all the seller of one city\n"
					+ "9. Show all the buyers of one city\n"
					+ "10. Show all items of one type ordered by price (asc)\n"
					+ "0. Leave the app");
			option = sc.nextInt();
			sc.nextLine();
			
			switch(option) {
			case 0: 
				System.out.println("You're leaving the app");
				break;
			case 1:
				System.out.println("Enter a name:");
				name = sc.nextLine();
				System.out.println("Enter a city:");
				city = sc.nextLine();
				addSeller(name, city);
				break;
			case 2:
				System.out.println("Enter the seller's name:");
				seller = sc.nextLine();
				indexSeller = findSeller(seller);
				if(indexSeller != -1) {
					addItemToSeller(seller, indexSeller);
				} else {
					System.out.println("There is no seller with this name");
				}
				break;
			case 3:
				cheapestItem();
				break;
			case 4:
				System.out.println("Enter the seller's name:");
				seller = sc.nextLine();
				indexSeller = findSeller(seller);
				if(indexSeller != -1) {
					listItems(seller, indexSeller);
				} else {
					System.out.println("There is no buyer with this name");
				}
				
				break;
			case 5:
				System.out.println("Enter a name:");
				name = sc.nextLine();
				System.out.println("Enter a city:");
				city = sc.nextLine();
				addBuyer(name, city);
				break;
			case 6:
				System.out.println("Enter the buyer's name:");
				buyer = sc.nextLine();
				indexBuyer = findBuyer(buyer);
				if(indexBuyer != -1) {
					buyItem(buyer, indexBuyer);
				} else {
					System.out.println("There is no buyer with this name");
				}
				break;
			case 7:
				listItemsBuyer();
				break;
			case 8:
				sellersOfCity();
				break;
			case 9:
				buyersOfCity();
				break;
			case 10:
				typeItemsOrdered();
				break;
			default:
				System.out.println("Write a correct option between 0 and 10");
				break;
			}
			
			
		} while(option != 0);
	}
	
	
	// MENU'S METHODS
	//1. Create a seller
	public static void addSeller(String name, String city){
		System.out.println("Choose a NPC type(Write the number)\n"
				+ "1. Farmer\n"
				+ "2. Thief\n"
				+ "3. Merchant");
		int optionNpc = sc.nextInt();
		sc.nextLine();
		switch(optionNpc) {
		case 1:
			sellers.add(new Farmer(name, city));
			break;
		case 2:
			sellers.add(new Thief(name, city));
			break;
		case 3:
			sellers.add(new Merchant(name, city));
			break;
		default: 
			System.out.println("Write a correct option between 1 and 3");
			break;
		}
		System.out.println("Seller saved successfully\n");
	}
	
	//2. Add item to seller's inventory
	public static void addItemToSeller(String seller, int indexSeller){
		try {
			sellers.get(indexSeller).addItem(new Item("wand","magic",50.5d, 100));
		} catch (FullInventoryException e) {
			e.printStackTrace();
		}
		System.out.println("Item created successfully\n");
	}
	
	//3. Show the cheapest item of all sellers of one city
	public static void cheapestItem(){
		List<Item> cheapestInCity = sellers.stream().min(Comparator.comparingDouble(Item::price));
		
	}
	
	//4. Show items of one seller
	public static void listItems(seller, indexSeller){
		
	}
	
	//5. Create a buyer
	public static void addBuyer(String name, String city){
		buyers.add(new Buyer(name, city));
		System.out.println("Buyer saved successfully\n");
	}
	
	//6. Buy one item
	public static void buyItem(String buyer, int indexBuyer){
		buyers.get(indexBuyer).buyItem(new Item("mushroom", "food", 60.0, 75));
	}
	
	//7.
	public static void listItemsBuyer(){
		
	}
	
	//8.
	public static void sellersOfCity(){
		
	}
	//9.
	public static void buyersOfCity(){
		
	}
	//10.
	public static void typeItemsOrdered(){
		
	}

	
	// OTHERS MANAGEMENT METHODS
	public static int findSeller(String nameSeller){
		boolean found = false;
		int i = 0;
		int indexSeller = -1;
		
		while(i <  sellers.size() && !found) {
			if(nameSeller.equalsIgnoreCase(sellers.get(i).getName())) {
				indexSeller = i;
				found = true;
			}
			i++;
		}
		return indexSeller;
	}
	
	public static int findBuyer(String nameBuyer){
		boolean found = false;
		int i = 0;
		int indexBuyer = -1;
		
		while(i <  buyers.size() && !found) {
			if(nameBuyer.equalsIgnoreCase(buyers.get(i).getName())) {
				indexBuyer = i;
				found = true;
			}
			i++;
		}
		return indexBuyer;
	}
}

package provaNivell;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MenuMngm {


	static Scanner sc = new Scanner(System.in);

	// MENU'S METHODS
	//1. Create a seller
	public static void addSeller(List<NPC> sellers, String name, String city){
		
		int optionNpc = ScData.enterInt("Choose a NPC type(Write the number)\n"
				+ "1. Farmer\n"
				+ "2. Thief\n"
				+ "3. Merchant");
	
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
	public static void addItemToSeller(List<NPC> sellers, String seller, int indexSeller){
		
		String nameIt = ScData.enterStr("Enter the item's name:");
		String typeIt = ScData.enterStr("Enter the item's type:");
		double priceIt = ScData.enterDouble("Enter the item's price:");

		try {
			sellers.get(indexSeller).addItem(new Item(nameIt, typeIt, priceIt));

		} catch (FullInventoryException e) {
			e.printStackTrace();
		}
		System.out.println("Item created successfully\n");
	}

	//3. Show the cheapest item of all sellers of one city
	public static void cheapestItem(List<NPC> sellers, String city){
		
		List<NPC> sellersInCity = new ArrayList<NPC>();
		sellersInCity = sellers.stream()
									.filter(s->s.getCity().equalsIgnoreCase(city))
									.collect(Collectors.toList());
		
		if(!sellersInCity.isEmpty()) {
			List<Item> itemsInCity = new ArrayList<Item>();
			itemsInCity = sellersInCity.stream()
					.flatMap(s->s.getItems().stream())
					.sorted(Comparator.comparingDouble(Item::getPrice))
					.collect(Collectors.toList());
			
			itemsInCity.stream().limit(1).forEach(System.out::println);
		} else {
			System.out.println("There are no sellers in this city");
		}
	}

	//4. Show items of one seller
	public static void listItems(List<NPC> sellers, String seller, int indexSeller){
		
		sellers.get(indexSeller).getItems().forEach(System.out::println);
	}

	//5. Create a buyer
	public static void addBuyer(List<Buyer> buyers, String name, String city){
		
		buyers.add(new Buyer(name, city));
		System.out.println("Buyer saved successfully\n");
	}

	//6. Buy one item
	public static void buyItem(List<Buyer> buyers, String buyer, int indexBuyer){
		
		String nameIt = ScData.enterStr("Enter the item's name:");
		String typeIt = ScData.enterStr("Enter the item's type:");
		double priceIt = ScData.enterDouble("Enter the item's price:");

		buyers.get(indexBuyer).buyItem(new Item(nameIt, typeIt, priceIt));
		System.out.println("Item bought successully");
	}

	//7. Show items of one buyer
	public static void listItemsBuyer(List<Buyer> buyers, String buyer, int indexBuyer){
		
		buyers.get(indexBuyer).getBoughtItems().forEach(System.out::println);
	}

	//8. Show all the sellers of one city
	public static void sellersOfCity(List<NPC> sellers, String city){		
		
		if(!sellers.isEmpty()) {
			List<NPC> sellersCity = sellers.stream().filter(s->s.getCity().equalsIgnoreCase(city)).toList();
		
			if(!sellersCity.isEmpty()) {
				sellersCity.forEach(System.out::println);
			} else {
				System.out.println("There are no sellers in this city yet");
			}
		} else {
			System.out.println("There are no sellers yet");
		}
	}

	//9. Show all the buyers of one city
	public static void buyersOfCity(List<Buyer> buyers, String city){	
		
		if(!buyers.isEmpty()) {	
			List<Buyer> buyersCity = buyers.stream().filter(b -> b.getCity().equalsIgnoreCase(city)).toList();
			
			if(!buyersCity.isEmpty()) {
				buyersCity.forEach(System.out::println);
			} else {
				System.out.println("There are no buyers in this city yet");
			}
		} else {
			System.out.println("There are no buyers yet");
		}
	}


	//10. Show all items of one type ordered by price (asc)
	public static void typeItemsOrdered(List<NPC> sellers, String type){
		
		List<Item> itemsType = sellers.stream().flatMap(s->s.getItems().stream())
				.filter(i->i.getType().equalsIgnoreCase(type))
				.toList();
		if(!itemsType.isEmpty()) {
			sellers.stream().flatMap(s->s.getItems().stream()) 
							.sorted(Comparator.comparingDouble(Item::getPrice))
							.filter(i->i.getType().equalsIgnoreCase(type))
							.forEach(System.out::println);	
		} else {
			System.out.println("This type of item doesn't exist yet");
		}

	}
}

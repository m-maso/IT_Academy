package provaNivell;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	static List<NPC> sellers = new ArrayList<NPC>();  
	static List<Buyer> buyers = new ArrayList<Buyer>();
	

	public static void main(String[] args) {
		
		DbStart.loadData(sellers, buyers);
				
		boolean leave = false;
	
		do {

			int option = 0;
			option = showMenu();

			String name, city, seller, buyer;
			int indexSeller, indexBuyer;

			switch(option) {	
			case 0: 
				System.out.println("You're leaving the app");
				leave = true;
				break;
			case 1:
				name = ScData.enterStr("Enter a name:");
				city = ScData.enterStr("Enter a city:");
				MenuMngm.addSeller(sellers, name, city);
				break;
			case 2:
				seller = ScData.enterStr("Enter the seller's name:");
				indexSeller = Find.findSeller(sellers, seller);
				if(indexSeller != -1) {
					MenuMngm.addItemToSeller(sellers, seller, indexSeller);
				} else {
					System.out.println("There is no seller with this name");
				}
				break;
			case 3:
				city = ScData.enterStr("Enter the name of the city:");
				MenuMngm.cheapestItem(sellers, city);
				break;
			case 4:
				seller = ScData.enterStr("Enter the seller's name:");
				indexSeller = Find.findSeller(sellers, seller);
				if(indexSeller != -1) {
					MenuMngm.listItems(sellers, seller, indexSeller);
				} else {
					System.out.println("There is no buyer with this name");
				}
				break;
			case 5:
				name = ScData.enterStr("Enter a name:");
				city = ScData.enterStr("Enter a city:");
				MenuMngm.addBuyer(buyers, name, city); 
				break;
			case 6:
				buyer = ScData.enterStr("Enter the buyer's name:");
				indexBuyer = Find.findBuyer(buyers, buyer);
				if(indexBuyer != -1) {
					MenuMngm.buyItem(buyers, buyer, indexBuyer);
				} else {
					System.out.println("There is no buyer with this name");
				}
				break;
			case 7:
				buyer = ScData.enterStr("Enter the buyer's name:");
				indexBuyer = Find.findBuyer(buyers, buyer);
				if(indexBuyer != -1) {
					MenuMngm.listItemsBuyer(buyers, buyer, indexBuyer);
				} else {
					System.out.println("There is no buyer with this name");
				}
				break;
			case 8:
				city = ScData.enterStr("Enter a city:");
				MenuMngm.sellersOfCity(sellers, city);
				break;
			case 9:
				city = ScData.enterStr("Enter a city:");
				MenuMngm.buyersOfCity(buyers, city);
				break;
			case 10:
				String type = ScData.enterStr("Enter the type of the items");
				MenuMngm.typeItemsOrdered(sellers, type);
				break;
			default:
				System.out.println("Write a correct option, a number between 0 and 10");
				break;
			}
			
		} while(!leave);

	}

	//Show menu options
	public static int showMenu() {
		int option = ScData.enterInt("\nNPCs APP MENU\n"
				+ "1. Create a seller\n"
				+ "2. Add item to seller's inventory\n"
				+ "3. Show the cheapest item of all sellers of one city\n"
				+ "4. Show items of one seller\n"
				+ "5. Create a buyer\n"
				+ "6. Buy one item\n"
				+ "7. Show items of one buyer\n"
				+ "8. Show all the sellers of one city\n"
				+ "9. Show all the buyers of one city\n"
				+ "10. Show all items of one type ordered by price (asc)\n"
				+ "0. Leave the app");
		return option;
	}
	
	

}

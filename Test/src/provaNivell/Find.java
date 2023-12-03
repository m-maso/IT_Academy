package provaNivell;

import java.util.List;

public class Find {

	// OTHERS MANAGEMENT METHODS
	
	public static int findSeller(List<NPC> sellers, String nameSeller){
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
	
	public static int findBuyer(List<Buyer> buyers, String nameBuyer){
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

package provaNivell;

import java.util.List;

public class DbStart {
	
	// DB: sellers, buyers and items
	public static void loadData(List<NPC> sellers, List<Buyer> buyers){
		
		sellers.add(new Farmer("Alex", "Blackpool"));
		sellers.add(new Farmer("Mary", "York"));
		sellers.add(new Thief("Simon", "London"));
		sellers.add(new Thief("Linda", "York"));
		sellers.add(new Merchant("Imogen", "Manchester"));
		sellers.add(new Merchant("Alice", "York"));
		try {
			sellers.get(0).addItem(new Item("wand","magic",50.5d));
			sellers.get(1).addItem(new Item("mushroom", "food", 25.0d));
			sellers.get(2).addItem(new Item("ax","fight",100.0d));
			sellers.get(3).addItem(new Item("apple","food", 1.5d));
			sellers.get(4).addItem(new Item("hammer", "tool", 60.0d));
			sellers.get(5).addItem(new Item("helmet","protection",100.0d));
			sellers.get(4).addItem(new Item("wand","magic",50.5d));
			sellers.get(0).addItem(new Item("mushroom", "food", 60.0d));
			sellers.get(1).addItem(new Item("ax","fight",100.0d));
			sellers.get(2).addItem(new Item("apple","food", 1.5d));
			sellers.get(3).addItem(new Item("hammer", "tool", 60.0d));
			sellers.get(5).addItem(new Item("helmet","protection",100.0d));
		} catch (FullInventoryException e) {
			e.printStackTrace();
		}
		
		buyers.add(new Buyer("John", "Leeds"));
		buyers.add(new Buyer("Mary", "York"));
		buyers.add(new Buyer("George", "Bristol"));
		buyers.add(new Buyer("Peter", "Bedford"));
		buyers.add(new Buyer("Mallika", "Bristol"));
		buyers.get(0).buyItem(new Item("wand","magic",50.5d));
		buyers.get(1).buyItem(new Item("mushroom", "food", 60.0d));
		buyers.get(2).buyItem(new Item("hammer", "tool", 60.0d));
		buyers.get(3).buyItem(new Item("ax","fight",100.0d));
		buyers.get(4).buyItem(new Item("ax","fight",100.0d));
		buyers.get(0).buyItem(new Item("apple", "food", 1.5d));
		buyers.get(1).buyItem(new Item("helmet","protection",100.0d));
		buyers.get(2).buyItem(new Item("wand","magic",50.5d));
		buyers.get(3).buyItem(new Item("mushroom", "food", 60.0d));
		buyers.get(0).buyItem(new Item("hammer", "tool", 60.0d));
		buyers.get(1).buyItem(new Item("ax","fight",100.0d));
	} 
}

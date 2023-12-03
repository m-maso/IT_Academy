package provaNivell;

public class Thief extends NPC {

	private static final int MAX_ITEMS = 3;
	private int wearPerc = 25;
	
	public Thief(String name, String city) {
		super(name, city);
	}
	
	public static int getMAX_ITEMS() {
		return MAX_ITEMS;
	}
	public int getWearPerc() {
		return this.wearPerc;
	}
	
	
	@Override
	public void addItem(Item item) throws FullInventoryException {	
		if(items.size() < MAX_ITEMS) {	
			
			item.setWear(100 - getWearPerc());
			
			items.add(item);
		} else {
			throw new FullInventoryException("Full inventory!! Buyer can't buy the item");
		}
	}
	
	@Override
	public String toString() {
		return "Thief-> Name: " + super.getName() + ", City: " + super.getCity();
	}
}

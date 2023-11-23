package provaNivell;

public class Farmer extends NPC {

	private static final int MAX_ITEMS = 5;
	private static final double TAX = 0.02d;
//	private double wearPerc = 0.15d;
	
	public Farmer(String name, String city) {
		super(name, city);
	}
	
	public static int getMAX_ITEMS() {
		return MAX_ITEMS;
	}
	public static double getTAX() {
		return TAX;
	}

	@Override
	public void addItem(Item item) throws FullInventoryException {	
		if(items.size() < MAX_ITEMS) {
			items.add(item);
		} else {
			throw new FullInventoryException("Full inventory!! Buyer can't buy the item");
		}
	}
}

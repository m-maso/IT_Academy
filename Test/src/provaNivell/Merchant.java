package provaNivell;

public class Merchant extends NPC {

	private static final int MAX_ITEMS = 7;
	private static final double TAX = 0.04d;
//	private double wearPerc = 0.0d;
	
	public Merchant(String name, String city) {
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

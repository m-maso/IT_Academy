package provaNivell;

public class Farmer extends NPC {

	private static final int MAX_ITEMS = 5;
	private static final double TAX = 0.02d;
	private int wearPerc = 15;
	
	public Farmer(String name, String city) {
		super(name, city);
	}
	
	public static int getMAX_ITEMS() {
		return MAX_ITEMS;
	}
	public static double getTAX() {
		return TAX;
	}
	private int getWearPerc() {
		return this.wearPerc;
	}

	
	@Override
	public void addItem(Item item) throws FullInventoryException {	
		if(items.size() < MAX_ITEMS) {
			double price = item.getPrice();
			price += (price * TAX);
			item.setPrice(price);
			
			item.setWear(100 - getWearPerc());
			
			items.add(item);
		} else {
			throw new FullInventoryException("Full inventory!! Buyer can't buy the item");
		}
	}
	
	@Override
	public String toString() {
		return "Farmer-> Name: " + super.getName() + ", City: " + super.getCity();
	}
}

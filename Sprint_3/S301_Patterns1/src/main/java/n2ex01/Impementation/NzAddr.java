package n2ex01.Impementation;

import n2ex01.Address;

public class NzAddr implements Address {

	private String road;
	private int unit;
	private int number;
	private String door;
	private String suburb;
	private String townCity;
	private String postcode;
	private static final String COUNTRY = "NEW ZEALAND";
	
	public NzAddr(String road, int unit, int number, String door, String townCity, String postcode, String suburb) {
		this.road = road;
		this.unit = unit;
		this.number = number;
		this.door = door;
		this.townCity = townCity;
		this.postcode = postcode;
		this.suburb = suburb;
	}
	
	@Override
	public String seeAddr() {
	
		return this.unit + " " + this.door + "/ " + this.number + " " + road + "\n\t\t"
				+ "   " + this.suburb + "\n\t\t"
				+ "   " + this.townCity + " " + postcode + "\n\t\t"
				+ "   " + COUNTRY;
	}

}

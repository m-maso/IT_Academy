package n2ex01.Impementation;

import n2ex01.Address;

public class UkAddr implements Address {

	private String road;
	private int number;
	private int floor;
	private String door;
	private String city;
	private String postcode;
	private String county;
	private static final String COUNTRY = "United Kingdom";
	
	public UkAddr(String road, int number, int floor, String door, String city, String postcode, String county) {
		this.number = number;
		this.road = road;
		this.floor = floor;
		this.door = door;
		this.city = city;
		this.postcode = postcode;
		this.county = county;
	}
	

	
	@Override
	public String seeAddr() {
		return this.floor + this.door + this.number + ", "+ this.road + "\n\t\t"
				+ "   " + this.city + ", " + this.postcode + "\n\t\t"
				+ "   " + this.county + "\n\t\t"
				+ "   " + COUNTRY;
	}

	
}

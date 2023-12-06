package n2ex01.Impementation;

import n2ex01.Address;

public class SpainAddr implements Address {

	private String road;
	private int number;
	private int floor;
	private String door;
	private String city;
	private String postcode;
	private String province;
	private static final String COUNTRY = "Spain";
	
	
	public SpainAddr(String road, int number, int floor, String door, String city, String postcode, String province) {
		this.road = road;
		this.number = number;
		this.floor = floor;
		this.door = door;
		this.city = city;
		this.postcode = postcode;
		this.province = province;
	}
	
	
	@Override
	public String seeAddr() {
		return this.road + ", " + this.number + ", " + this.floor + "-" + this.door + ".\n\t\t"
				+ "   " + this.city + ", " + this.postcode + ".\n\t\t"
				+ "   " + this.province + ", " + COUNTRY;
	}

}

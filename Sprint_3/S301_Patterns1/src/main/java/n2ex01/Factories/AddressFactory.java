package n2ex01.Factories;

import n2ex01.Address;
import n2ex01.Phone;
import n2ex01.Impementation.NzAddr;
import n2ex01.Impementation.SpainAddr;
import n2ex01.Impementation.UkAddr;

public class AddressFactory extends AbstractFactory {

	@Override
	public Address getAddress(String country, String road, int number, int floor, String door, String city, String postcode,
			String county) {
		
		if(country.equalsIgnoreCase("Spain")) {
			return new SpainAddr(road, number, floor, door, city, postcode, county);
		} else if(country.equalsIgnoreCase("UK")) {
			return new UkAddr(road, number, floor, door, city, postcode, county);
		} else if(country.equalsIgnoreCase("NZ")) {
			return new NzAddr(road, number, floor, door, city, postcode, county);
		}
		return null;
	}
	
	@Override
	public Phone getPhone(String country, int phoneNum) {
		return null;
	}

	
}

package n2ex01.Factories;

import n2ex01.Address;
import n2ex01.Phone;
import n2ex01.Impementation.NzPhone;
import n2ex01.Impementation.SpainPhone;
import n2ex01.Impementation.UkPhone;

public class PhoneFactory extends AbstractFactory {


	@Override
	public Address getAddress(String country, String road, int number, int floor, String door, String city, String postcode,
			String county) {
		return null;
	}
	
	@Override
	public Phone getPhone(String country, int phoneNum) {
		
		if(country.equalsIgnoreCase("Spain")) {
			return new SpainPhone(phoneNum);
		} else if(country.equalsIgnoreCase("uk")) {
			return new UkPhone(phoneNum);	
		}else if(country.equalsIgnoreCase("NZ")) {
			return new NzPhone(phoneNum);
		}
		return null;
	}

}

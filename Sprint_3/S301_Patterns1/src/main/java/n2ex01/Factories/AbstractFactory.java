package n2ex01.Factories;

import n2ex01.Address;
import n2ex01.Phone;

public abstract class AbstractFactory {

	public abstract Address getAddress(String country, String road, int number, int floor, String door, String city, String postcode, String county);
	public abstract Phone getPhone(String country, int phoneNum);

}

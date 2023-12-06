package n2ex01.Factories;

public class FactoryProducer {

//	Choose factory
	
	public static AbstractFactory getFactory(String FactoryType) {
		if(FactoryType.equalsIgnoreCase("ADDRESS")) {
			return new AddressFactory();
		} else if(FactoryType.equalsIgnoreCase("PHONE"))  {
			return new PhoneFactory();
		}
		return null;
	}
}

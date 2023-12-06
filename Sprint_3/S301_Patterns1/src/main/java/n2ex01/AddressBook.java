package n2ex01;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import n2ex01.Factories.AddressFactory;
import n2ex01.Factories.PhoneFactory;

public class AddressBook {

	static List<Contact> addrBook = new ArrayList<Contact>();
	
	// 1. Create a contact
	public static void addContact(){
		
		System.out.println("Please enter the following data to create a new contact");
		// Name
		String contactName = ScData.enterStr("Enter your first and last name:");
		
		// Address
		String country = ScData.enterStr("Enter your country:");
		
		String road = ScData.enterStr("Enter road/street:");
		int number = ScData.enterInt("Enter road/street number:");
		int floor = ScData.enterInt("Enter floor/flat number:");
		String door = ScData.enterSimpleStr("Enter door:");
		String city = ScData.enterStr("Enter town/city:");
		String postcode = ScData.enterSimpleStr("Enter postcode:");
		String county = ScData.enterStr("Enter province/county/suburb:");
		
		AddressFactory addrFactory = new AddressFactory();
		Address address = addrFactory.getAddress(country, road, number, floor, door, city, postcode, county);
		
		// Phone
		int phoneNum = ScData.enterInt("Enter your phone number without prefix:");

		PhoneFactory phoneFact = new PhoneFactory();
		Phone phone = (Phone) phoneFact.getPhone(country, phoneNum);
		
		// Contact
		addrBook.add(new Contact(contactName, address, phone));		
		System.out.println("Contact created successfully");
	}
	
	// 2. Show one contact
	public static void showContact(){
		
		String name = ScData.enterStr("Enter the name of the contact you want to see:");
		Contact cont = findContact(name);
		System.out.println(cont.toString());
	}
	
	// 3. Show all contacts
	public static void showAllContacts(){
		addrBook.forEach(System.out::println);
	}
	
	// 4. Delete one contact
	public static void deleteContact(){
		String name = ScData.enterStr("Enter the name of the contact you want to delete:");
		Contact cont = findContact(name);
		addrBook.remove(cont);
		System.out.println("Contact deleted successfully");
	}
	
	
	// Mngm Method: Find contact
	public static Contact findContact(String name) {
		Optional<Contact> cont = addrBook.stream()
												.filter(c-> c.getName().equalsIgnoreCase(name))
												.findFirst();
		return cont.get();
	}

}

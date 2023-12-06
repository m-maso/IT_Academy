package n2ex01;

public class App {

	public static void main(String[] args) {
		
		boolean leave = false;
		
		do {
			int option = 0;
			option = showMenu();
			
			switch(option) {
			case 0:
				System.out.println("You're leaving the app");
				leave = true;
				break;
			case 1:
				AddressBook.addContact();
				break;
			case 2:
				AddressBook.showContact();
				break;
			case 3:
				AddressBook.showAllContacts();
				break;
			case 4:
				AddressBook.deleteContact();
				break;
			default: 
				System.out.println("Enter a correct option");
			}
		} while(!leave);
			
	}

	private static int showMenu() {
		int option = ScData.enterInt("\nADDRESSBOOK APP MENU\n"
				+ "1. Create a contact\n"
				+ "2. Show one contact\n"
				+ "3. Show all contacts\n"
				+ "4. Delete one contact\n"
				+ "0. Leave the app");
		return option;
	}

}

package n2ex01;

public class Contact {

	private String name;
	private Address address;
	private Phone phone;
	
	public Contact(String name, Address address, Phone phone) {
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	public Contact(Address address, Phone phone) {
		this.address = address;
		this.phone = phone;
	}

	public String getName() {
		return this.name;
	}

	public Address getAddress() {
		return this.address;
	}

	public Phone getPhone() {
		return this.phone;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "Contact-> Name: " + this.name + "\n\t"
					 + "  Address: " + this.address.seeAddr() + ".\n\t"
					 + "  Phone: " + this.phone.seePhone();
	}
}

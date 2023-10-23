package n3ex01;

import java.util.Comparator;

public class Person implements Comparable<Person>{
	
	// Attrib
	private String firstName;
	private String lastName;
	private String nif;
	
	// Constr
	public Person(String firstName, String lastName, String nif) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.nif = nif;
	}
	
	// Getters
	public String getFirstName() {
		return this.firstName;
	}
	public String getLastName() {
		return this.getLastName();
	}
	public String getnif() {
		return this.nif;
	}
	// Setters 
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setnif(String nif) {
		this.nif = nif;
	}
	
	// Own Methods
	@Override
	public String toString() {
		return  this.firstName + " " +  this.lastName + ", " + this.nif;
	}

	@Override
	public int compareTo(Person o) {
		return Comparators.FirstName.compare(this, o);
	}
	
	public static class Comparators {
		
		public static Comparator<Person> FirstName = new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				return p1.firstName.compareToIgnoreCase(p2.firstName);	
			}
		};
		
		public static Comparator<Person> LastName = new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				return p1.lastName.compareToIgnoreCase(p2.lastName);	
			}
		};
		
		public static Comparator<Person> Nif = new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				return p1.nif.compareToIgnoreCase(p2.nif);	
			}
		};
	}
}

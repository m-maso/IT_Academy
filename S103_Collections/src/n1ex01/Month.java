package n1ex01;

import java.util.Objects;

public class Month {
	// Attrib
	private String name;
	
	// Constr
	public Month(String name) {
		this.name = name;
	}
	
	// Getter
	public String getName() {
		return this.name;
	}
	
	// Setter
	public void setName(String name) {
		this.name = name;
	}
	
	// Methods
	@Override
	public String toString() {
		return "Month of " + this.name;
	}
	// Check duplicates with Hashcode and Equals (name as obj. attrib)

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Month other = (Month) obj;
		return Objects.equals(name, other.name);
	}

}
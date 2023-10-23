package n2ex02;

import java.util.Objects;

public class Restaurant implements Comparable<Restaurant> {

	// Attrib
	private String name;
	private int score;
	
	// Constr
	public Restaurant(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	// Getters
	public String getName() {
		return this.name;
	}
	public int getScore() {
		return this.score;
	}
	
	// Setters
	public void setName(String name) {
		this.name = name;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	// Methods	
	@Override
	public int hashCode() {
		return Objects.hash(name, score);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Restaurant other = (Restaurant) obj;
		return Objects.equals(name, other.name) && (score == other.score);
	}
	
	@Override
	public String toString() {
		return "Restaurant name: " + this.name + "\nRestaurant Score: " + this.score + " points\n";
	}
	//----- final previous ex.
	
	//----- Current ex.
	@Override
	public int compareTo(Restaurant other) {
		// Name  Asc. sorting
		int compByName = this.getName().compareTo(other.getName());
		if(compByName != 0) {
			return compByName;
		}
		// Score Asc. sorting
		return Integer.compare(this.score, other.score);
	}
}

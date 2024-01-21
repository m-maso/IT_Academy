package cat.itacademy.S04T02N02MasoMontse.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fruit")
public class Fruit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 30)
	private String name;
	
	@Column(length = 8)
	private int kgs;
	
	
	public Fruit() {}
	
	public Fruit(int id, String name, int kgs) 
	{
		this.id = id;
		this.name = name;
		this.kgs = kgs;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getKgs() {
		return kgs;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setKgs(int kgs) {
		this.kgs = kgs;
	}

	public String toString() {
		return "Fruit-> Id: " + this.id + ", Name: " + this.name + ", " + this.kgs + " Kgs";
	}
}

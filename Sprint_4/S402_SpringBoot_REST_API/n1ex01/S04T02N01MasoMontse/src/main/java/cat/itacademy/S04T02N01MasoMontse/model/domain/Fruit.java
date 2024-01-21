package cat.itacademy.S04T02N01MasoMontse.model.domain;

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
	
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	
	@Column(name = "kgs", nullable = false, length = 8)
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
	
	public void setName(String name) {
		this.name = name;
	}
	public void setKgs(int kgs) {
		this.kgs = kgs;
	}
	
	public String toString() 
	{
		return "Fruit-> Id: " + this.id + ", Name: " + this.name + ", " + this.kgs + " Kgs";
	}
}

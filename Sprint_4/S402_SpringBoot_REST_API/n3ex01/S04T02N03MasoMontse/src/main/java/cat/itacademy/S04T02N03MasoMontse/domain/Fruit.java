package cat.itacademy.S04T02N03MasoMontse.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "fruits")
public class Fruit {

	@Id
	@Indexed(unique = true)
	private ObjectId id;
	
	@Indexed(unique = true)
	private String name;
	private int kgs;
	
	
	public Fruit() {}
	
	public Fruit(ObjectId id, String name, int kgs) 
	{
		this.id = id;
		this.name = name;
		this.kgs = kgs;
	}
	
	public ObjectId getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getKgs() {
		return kgs;
	}
	
	public void setId(ObjectId id) {
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

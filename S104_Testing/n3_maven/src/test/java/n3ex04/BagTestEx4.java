package n3ex04;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.Test;

public class BagTestEx4 {

	Bag bag1 = new Bag("Lässig", "violet");
	Bag bag2 = new Bag("Eastpak", "blue");
	Bag bag3 = new Bag("Vans", "red");
	
	Book book1 = new Book("Learn English 1", "English");
	Book book2 = new Book("Literatura Catalana 1", "Català");
	Book book3 = new Book("Matemàtiques 2", "Mates");
	Book book4 = new Book("Ciències naturals 3", "Ciències");
	Book book5 = new Book("Pintar amb aquarel·la", "Plàstica");
	
	ArrayList<Object> listObj = new ArrayList<Object>();
	
	public void addObj() {
		listObj.add(bag1);
		listObj.add(bag2);
		listObj.add(bag3);
		
		listObj.add(book1);
		listObj.add(book2);
		listObj.add(book3);
		listObj.add(book4);
	}
	
	// Verify list has obj in input order
	@Test
	public void inInputOrder() {
		addObj();
		assertThat(listObj).containsExactly(bag1, bag2, bag3, book1, book2, book3, book4);
	}
	
	// Verify list has obj in any order
	@Test
	public void inAnyOrder() {
		addObj();
		assertThat(listObj).contains(bag1, book3, book2, book4, bag3, bag2, book1);
	}
	
	// Verify 1 obj with 1 input only
	@Test
	public void addOnce() {
		addObj();
		assertThat(listObj).containsOnlyOnce(book4);
	}
	
	// Don't add 1 obj and verify the list doesn't have it
	@Test
	public void notContains() {
		addObj();
		assertThat(listObj).doesNotContain(book5);
	}
}

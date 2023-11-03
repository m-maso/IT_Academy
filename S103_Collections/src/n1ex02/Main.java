package n1ex02;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Main {

	public static void main(String[] args) {
		
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(0);
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(5);
		list1.add(6);
		list1.add(7);
		list1.add(8);
		list1.add(9);
		list1.add(10);
		//show list1
		System.out.println("Created List<Integer> with elements");
		for(int j = 0; j < list1.size(); j++) { 
			System.out.println(list1.get(j));
		}
		
		// Create a new list with elements of 1st list in reverse order
		List<Integer> list2 = new ArrayList<Integer>();
		
		ListIterator<Integer> list1Iterator = list1.listIterator(list1.size());
		
		while(list1Iterator.hasPrevious()) {
			list2.add(list1Iterator.previous());
		}
		//show list2
		System.out.println("New List<Integer> created with elements of first list in reverse order");
		for(int i = 0; i < list2.size(); i++) {
			System.out.println(list2.get(i));
		}
	}

}

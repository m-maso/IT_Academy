package n2ex02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		
		// Create HashSet with Restaurant objects
		HashSet<Restaurant> restaurants = new HashSet<Restaurant>();
		
		restaurants.add(new Restaurant("Can Marià", 8));
		restaurants.add(new Restaurant("La barbacoa", 7));
		restaurants.add(new Restaurant("Cuina de casa", 9));
		restaurants.add(new Restaurant("El brou", 6));
		
		// Print current HashSet of Restaurants
//				Iterator<Restaurant> itr = restaurants.iterator();
//				while(itr.hasNext()) {
//					System.out.println(itr.next());
//				}
		
		// Can only exist restaurants with same when the score is different (never with same score)
			// Try to duplicate restaurants (same name, same score)
		restaurants.add(new Restaurant("Can Marià", 8));
		restaurants.add(new Restaurant("El brou", 6));
		
			// Try to duplicate restaurants (same name, different score)
		restaurants.add(new Restaurant("Can Marià", 7));
		restaurants.add(new Restaurant("El brou", 5));
		
		// Print current HashSet of Restaurants
		System.out.println("List of restaurants after trying to duplicate some of them");
		for(Restaurant restaurant : restaurants) {
			System.out.println(restaurant.toString());
		}
		//----- final previous ex.
		
		//----- Current ex.
		// Create a TreeSet to sort objects of class Restaurant ordered by name and score (asc. order)
		TreeSet<Restaurant> restaurantsTS = new TreeSet<Restaurant>(restaurants);
		
		// Print objects of class Restaurant ordered by name and score (asc. order)
		System.out.println("List of restaurants sorted in asc. order (by name and score)");
		
		Iterator<Restaurant> it = restaurantsTS.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	
		
	}

}

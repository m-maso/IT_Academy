package n3ex01;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {

		// Items
		List<Item> items = new ArrayList<Item>();
		
		items.add(new Item("Reflex camera", 765.56));
		items.add(new Item("Tripod", 765.56));
		items.add(new Item("Flash", 94.76));
		items.add(new Item("Reflectors", 23.02));
		
		
		// Stores
		ScreenPrices BcnStore = new ScreenPrices("eur");
		ScreenPrices LondonStore = new ScreenPrices("gbp");
		ScreenPrices TokioStore = new ScreenPrices("jpy");
		ScreenPrices WellingtonStore = new ScreenPrices("nzd");
		
		// Display prices
		System.out.println("\nBarcelona Store prices:");
		items.forEach(BcnStore::showPrices);
		
		System.out.println("\nLondon Store prices:");
		items.forEach(LondonStore::showPrices);
		
		System.out.println("\nTokio Store prices:");
		items.forEach(TokioStore::showPrices);
		
		System.out.println("\nWellington Store prices:");
		items.forEach(WellingtonStore::showPrices);
	}

}

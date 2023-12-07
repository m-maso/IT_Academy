package n3ex01;

import n3ex01.CurrExchange.Eur;
import n3ex01.CurrExchange.EurToGBP;
import n3ex01.CurrExchange.EurToJPY;
import n3ex01.CurrExchange.EurToNZD;

public class ScreenPrices {

	CurrencyExchange curExchange;
	private String curr;
	
	public ScreenPrices(String currency) {
		currency = currency.toUpperCase();
		
		switch(currency) {
		case "EUR":
			curExchange = new Eur();
			curr = "€";
			break;
		case "GBP":
			curExchange = new EurToGBP();
			curr = "£";
			break;
		case "JPY":
			curExchange = new EurToJPY();
			curr = "¥";
			break;
		case "NZD":
			curExchange = new EurToNZD();
			curr = "NZ$";
			break;
		default:
			System.out.println("Sorry, there are no more international stores at the moment");
		}
	}
	
	public void showPrices(Item item) {
		double exchangedPrice = curExchange.currExchange(item.getPrice());
		System.out.printf("- %s, %.2f %s %n", item.getName(), exchangedPrice, curr);
	}
}

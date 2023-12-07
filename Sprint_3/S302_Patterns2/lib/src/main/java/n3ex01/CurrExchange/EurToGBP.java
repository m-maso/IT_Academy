package n3ex01.CurrExchange;

import n3ex01.CurrencyExchange;

// SERVICE

public class EurToGBP implements CurrencyExchange {

	@Override
	public double currExchange(double origPrice) {
		return origPrice*0.85;
	}

}

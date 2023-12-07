package n3ex01.CurrExchange;

import n3ex01.CurrencyExchange;

//SERVICE

public class Eur implements CurrencyExchange {

	@Override
	public double currExchange(double origPrice) {
		return origPrice;
	}

}

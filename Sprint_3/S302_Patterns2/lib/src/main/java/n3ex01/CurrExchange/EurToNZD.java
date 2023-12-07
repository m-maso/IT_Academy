package n3ex01.CurrExchange;

import n3ex01.CurrencyExchange;

public class EurToNZD implements CurrencyExchange {

	@Override
	public double currExchange(double origPrice) {
		return origPrice*1.75;
	}

}

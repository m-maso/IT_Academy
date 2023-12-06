package n2ex01.Impementation;

import n2ex01.Phone;

public class SpainPhone implements Phone {

	private static final String PREFIX = "+34";
	protected int phoneNum;
	
	
	public SpainPhone(int phoneNum){
		this.phoneNum = phoneNum;
	}


	@Override
	public String seePhone() {
		return PREFIX + " " + this.phoneNum;
	}

	
}

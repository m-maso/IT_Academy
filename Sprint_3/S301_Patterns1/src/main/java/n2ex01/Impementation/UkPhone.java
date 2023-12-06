package n2ex01.Impementation;

import n2ex01.Phone;

public class UkPhone implements Phone {

	private static final String PREFIX = "+44";
	protected int phoneNum;
	
	public UkPhone(int phoneNum){
		this.phoneNum = phoneNum;
	}

	
	@Override
	public String seePhone() {
		return PREFIX + " " + this.phoneNum;
	}
	
	

}

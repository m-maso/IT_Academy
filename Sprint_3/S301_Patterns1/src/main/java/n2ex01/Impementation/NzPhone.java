package n2ex01.Impementation;

import n2ex01.Phone;

public class NzPhone implements Phone {

	private static final String PREFIX = "+64";
	protected int phoneNum;
	
	public NzPhone(int phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	
	@Override
	public String seePhone() {
		return PREFIX + " " + this.phoneNum;
	}

}

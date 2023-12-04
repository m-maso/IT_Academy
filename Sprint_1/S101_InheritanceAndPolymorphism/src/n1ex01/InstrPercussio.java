package n1ex01;

public class InstrPercussio extends Instrument {
	
	public InstrPercussio(String nom, int preu) {
		super(nom, preu);
	}
	
	@Override
	public String tocar() {
		return "Està sonant un instrument de percussió";
	}
}

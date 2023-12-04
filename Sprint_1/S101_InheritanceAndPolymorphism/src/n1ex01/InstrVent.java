package n1ex01;

public class InstrVent extends Instrument {
	
	public InstrVent(String nom, int preu) {
		super(nom, preu);
	}
	
	@Override
	public String tocar() {
		return "Està sonant un intstrument de vent";
	}
	
}

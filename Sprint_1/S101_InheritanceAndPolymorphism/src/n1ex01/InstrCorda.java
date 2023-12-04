package n1ex01;

public class InstrCorda extends Instrument {

	public InstrCorda(String nom, int preu) {
		super(nom, preu);
	}
	
	@Override
	public String tocar() {
		return "Està sonant un instrument de corda";
	}
	
}

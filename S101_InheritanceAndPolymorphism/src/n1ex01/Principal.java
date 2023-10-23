package n1ex01;

public class Principal {
	
	static 
	{
		System.out.println("Comença inicialització bloc static");
	}

	public static void main(String[] args) {
		
		Instrument corda1 = new InstrCorda("violí",1000);
		System.out.println(corda1.tocar());
	
		Instrument vent1 = new InstrVent("clarinet", 600);
		System.out.println(vent1.tocar());
		
		Instrument perc1 = new InstrPercussio("xilòfon", 200);
		System.out.println(perc1.tocar());

	}

}

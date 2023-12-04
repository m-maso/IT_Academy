package n1ex01;

public class Principal {
	
	//s'inicialitza quan es carrega la classe
	static 
	{
		System.out.println("Inicialització bloc static a la classe Principal\n");
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("Càrrega provocada per la creació de la primera instància");
		
		InstrCorda corda1 = new InstrCorda("violí",1000);
		System.out.println(corda1.tocar() + "\n");
	
		InstrVent vent1 = new InstrVent("clarinet", 600);
		System.out.println(vent1.tocar() + "\n");
		
		InstrPercussio perc1 = new InstrPercussio("xilòfon", 200);
		System.out.println(perc1.tocar() + "\n");

		System.out.println("Càrrega provocada per l'accés a un membre static"); 
		Instrument.metodeStatic();
	}

}

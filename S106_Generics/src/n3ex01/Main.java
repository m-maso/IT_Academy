package n3ex01;

public class Main {

	public static void main(String[] args) {
	
		Smartphone smartphone = new Smartphone("Samsung","A51");
		
		// Calling generic methods
		System.out.println("Generic phone methods:");
		Generic.genPhone(smartphone);
		System.out.println("Generic Smartphone methods:");
		Generic.genSmartphone(smartphone);
		
		
	}

}

package n1ex02;

public class Principal {

	public static void main(String[] args) {
		// invocar mètode estàtic i no estàtic
		
		Cotxe.frenar();
		
		Cotxe cotxe1 = new Cotxe("Civic");
		cotxe1.accelerar();
	}

}

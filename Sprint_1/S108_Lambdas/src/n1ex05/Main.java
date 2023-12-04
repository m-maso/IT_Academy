package n1ex05;

public class Main {

	
	public static void main(String[] args) {
		// Create an instance of the interface and assign it a double value
		PiFuncInterf lambdaPi = () -> 3.1415d;
		System.out.println(lambdaPi.getPiValue());
		
	}

}

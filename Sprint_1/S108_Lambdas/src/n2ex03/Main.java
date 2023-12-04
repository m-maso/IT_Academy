package n2ex03;

public class Main {

	public static void main(String[] args) {
		
		OpFuncInterf add = (a, b) -> a + b; 
		OpFuncInterf subtract = (a, b) -> a - b;
		OpFuncInterf multip = (a, b) -> a * b;
		OpFuncInterf divide = (a, b) -> a / b;
		
		System.out.println(add.mathOperations(22.0f, 34.0f));
		System.out.println(subtract.mathOperations(550.5f, 25.75f));
		System.out.println(multip.mathOperations(6.0f, 9.0f));
		System.out.println(divide.mathOperations(7589.6f, 3.5f));
	}

}

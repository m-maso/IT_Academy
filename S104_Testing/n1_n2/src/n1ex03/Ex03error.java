package n1ex03;

public class Ex03error {

	
	public void generateErrorArrInd(int index) throws ArrayIndexOutOfBoundsException {
		index = 4;
		String[] armari = new String[] {"samarreta","faldilla","pantalons"};
		System.out.println(armari[index]);
	} 
	
}

package n1ex02;

public class CalculateDni {
	
	public static void main(String[] args) {
		
		System.out.println(calcDniLetter(01234567));
	}
	
	
	/** Calculate dni letter -> take modul of dni/23 (result between 0-22)
	 *  result = letter in array pos.
	 * */

	public static char calcDniLetter(int dniNum) {
		char correctLetter = ' ';
		char[] dniLetters = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 
				 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'}; 
		int calcLetterPos = dniNum % 23;
		correctLetter = dniLetters[calcLetterPos];
		return correctLetter;
	}
}

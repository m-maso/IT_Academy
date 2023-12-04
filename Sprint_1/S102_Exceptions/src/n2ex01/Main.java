package n2ex01;

public class Main {

	public static void main(String[] args) {
		boolean correct = true; 
		int loop_num = 1;
		
		do {
			Entry entry = new Entry();
			try {
				// Methods that catch exception class InputMismatchException:
				if(loop_num == 1) {
					byte resultByte = Entry.readByte("Enter a byte");
					System.out.println("Result byte: " + resultByte);
					loop_num++;
				}
				if(loop_num == 2) {
					int resInt = Entry.readInt("Enter an Integer");
					System.out.println("Result int: " + resInt);
					loop_num++;
				}
				if(loop_num == 3) {
					float resFloat = Entry.readFloat("Enter a float");
					System.out.println("Result float: " + resFloat);
					loop_num++;
				}
				if(loop_num == 4) {
					double resDouble = Entry.readDouble("Enter a double");
					System.out.println("Result double: " + resDouble);
					loop_num++;
				}	
 	
				// Methods that catch exception class Exception
				if(loop_num == 5) {
					char resChar = Entry.readChar("Enter a character");
					System.out.println("Result character: " + resChar);
					loop_num++;
				}
				if(loop_num == 6) {
					String resString = Entry.readString("Enter a phrase");
					System.out.println("Result phrase: " + resString);	
					loop_num++;
				}
				boolean resBoolean = Entry.readYesNo("Do you like to answer quizzes: enter 'y' for yes and 'n' for no");
				System.out.println("Result y/n: " + resBoolean);

				
				correct = false;
			} catch(Exception e) { // The exception InputMismatchException is already caught by Exception
				System.out.println("Found format error" );
			}
		} while(correct);
	}
}

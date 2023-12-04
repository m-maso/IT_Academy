package n2ex01;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Entry {

	private static Scanner sc;
	
	public Entry() {
		sc = new Scanner(System.in);
	}
	
	// Methods that catch exception class InputMismatchException:
	public static byte readByte(String msg)throws InputMismatchException {
		byte value = 0;
		System.out.println(msg);
		value = sc.nextByte();
		return value;
	}
	
	public static int readInt(String msg) throws InputMismatchException {
		int value = 0;
		System.out.println(msg);
		value = sc.nextInt();
		return value;
	}
	
	public static float readFloat(String msg) throws InputMismatchException {
		float value = 0.0f;
		System.out.println(msg);
		value = sc.nextFloat();
		return value;
	}
	
	public static double readDouble(String msg) throws InputMismatchException {
		double value = 0.0d;
		System.out.println(msg);
		value = sc.nextDouble();
		sc.nextLine();
		return value;
	}
	
	// Methods that catch exception class Exception
	public static char readChar(String msg) throws Exception {
		String str = "";
		char value = ' ';
		
		System.out.println(msg);
		str = sc.nextLine();
		value = str.charAt(0);
		if(Character.isDigit(value) || str.length() != 1) {
			throw new Exception();
		}
			
		return value;
	}
	
	public static String readString(String msg) throws Exception {
		String value = "";
		String regExpr = "^[0-9]+$"; //only numbers
		
		System.out.println(msg);
		value = sc.nextLine();
		if(value.length() <= 1 || value.matches(regExpr)) {
			throw new Exception();
		}
		return value;
	}
		
	public static boolean readYesNo(String msg) throws Exception {
		String entry = "";
		char character = ' ';
		boolean value = false;
	
		System.out.println(msg);
		entry = sc.nextLine();
		character = entry.charAt(0);
		if(character == 'y') {
			value = true;
		} else if(character == 'n') {
			value = false;
		} else {
			throw new Exception();
		}
		return value;
	}
		
}
package n2ex01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScData {

static Scanner sc = new Scanner(System.in);
	
	public static String enterStr(String msgXuser) {
		String str = "";
		boolean isString = false;
		String regExpr = "^[0-9]+$";
		
		do {
			System.out.println(msgXuser);
			try {
				str = sc.nextLine();
				
				if(str.length() <= 1 || str.matches(regExpr) ) {
					throw new Exception();
				}
				isString = true;
			} catch(Exception e) {
				System.err.println("Format error: Do not enter only numbers or only a character");
			}
		} while(!isString);
		return str;
	}
	
	
	public static int enterInt(String msgXuser) {	
		int num = 0;
		boolean isInt = false;
		
		do {
			try {
				System.out.println(msgXuser);
				num = sc.nextInt();
				isInt = true;
			} catch(InputMismatchException e) {
				System.err.println("Format error: please enter a number");
			}
			sc.nextLine();
		} while(!isInt);
		return num;
	} 
	
	public static String enterSimpleStr(String msgXuser) {
		System.out.println(msgXuser);
		String str = sc.nextLine();
		return str;
	}
}

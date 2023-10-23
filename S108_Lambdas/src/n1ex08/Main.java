package n1ex08;

public class Main {

	public static void main(String[] args) {
 
		String userStr = "Halloween";
		StringBuilder sb = new StringBuilder(userStr);
		
		ReverseFuncInterf lambdaReverse = word -> sb.reverse().toString();
		System.out.println(lambdaReverse.reverse(userStr));
	}

}

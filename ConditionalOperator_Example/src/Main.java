import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		System.out.print("Enter a number: ");		
		Scanner input = new Scanner(System.in);		
		int N = input.nextInt();
		
		int next = (N % 2 == 0) ? (N/2) : (3*N+1);
		// the value N/2 to next if N is even (that is, if N % 2 == 0 is true), and it will assign the value (3*N+1) to next if N is odd.
		
		System.out.print(next);

		
		//boolean-expression ? expression1 : expression2
		//The computer tests the value of boolean-expression. If the value is true, it evaluates expression1; otherwise, it evaluates expression2.
		
	}

}

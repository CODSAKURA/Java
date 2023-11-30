

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int temperature;
		System.out.print("Enter a temperature: ");
		Scanner input = new Scanner(System.in);
		temperature = input.nextInt();
		
		
		if (temperature < 50)
			   System.out.println("It's cold.");
			else if (temperature < 80)
			   System.out.println("It's nice.");
			else if (temperature > 100)
			   System.out.println("It's hot.");
		else
		;
		//the empty statement. This is a statement that consists simply of a semicolon and which tells the computer to do nothing
	}
}
		
		/*if (test-1)
	     statement-1
	     else if (test-2)
	          statement-2
	     else if (test-3)
	          statement-3
	       .
	       . // (more cases)
	       .
	     else if (test-N)
	          statement-N
	     else
	          statement-(N+1)
		}
		You can go on stringing together "else-if's" to make multiway branches with any number of cases
		*/


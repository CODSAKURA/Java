

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.print("Enter a word: ");
		Scanner input = new Scanner(System.in);
		System.out.println(input.hasNext());
		System.out.println(input.hasNextInt());
		System.out.println(input.hasNextDouble());
		System.out.println(input.hasNextLine());
		
		/*scanner.hasNext() — returns a boolean value that is true if there is at least one more token in the input source.
		  scanner.hasNextInt(), scanner.hasNextDouble(), and so on — return a boolean value that is true if there is at least one more token in the input source and that token represents a value of the requested type.
		  scanner.hasNextLine() — returns a boolean value that is true if there is at least one more line in the input source
		  
		 nextInt(): it only reads the int value, nextInt() places the cursor in the same line after reading the input.
		 next(): read the input only till the space. It can't read two words separated by space. Also, next() places the cursor in the same line after reading the input.
         nextLine():  reads input including space between the words (that is, it reads till the end of line \n). Once the input is read, nextLine() positions the cursor in the next line.
		 */

	}

}

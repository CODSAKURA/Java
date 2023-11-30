package readingnumberinaloop;

import java.util.Scanner;

public class R {

	public static void main(String[] args) {

		System.out.print("Enter a group of number:");
		Scanner input = new Scanner(System.in);
		
		while (input.hasNextInt()) 
		{
		 int value = input.nextInt();
		 System.out.println(value++);	 
		}	
	}
	//while总是为true，总是在执行不可能执行到while语句块后面的语句，你可以改变while终止的条件，就可执行while后面的语句。
}

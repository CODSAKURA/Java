package ArrayExample3;

import java.util.Scanner;

/**
 * Reads up to 100 integers from the user, then prints them
 * in reverse order.  An input of zero marks the end of input.
 */
//这个管输入的数额是到10。
public class ReverseArray {

   private static Scanner a;

   public static void main(String[] args) {
   
	   int[] numbers;  // An array for storing the input values.
	   int count;      // The number of numbers saved in the array.
	   int num;        // One of the numbers input by the user.
	   int i;          // for-loop variable.
     
	   numbers = new int[10];   // Space for 100 ints.
	   count = 0;                // No numbers have been saved yet.
     
	   System.out.println("Enter up to 100 positive integers; enter 0 to end.");     
	   while (true) 
	   {   
		   if(count == 10)
		   {
			   System.out.println("out of bound!!!");
			   break;
		   }
		   // Get the numbers and put them in the array.
		   System.out.print("? ");
		   a = new Scanner(System.in);
		   num = a.nextInt();
		   if (num <= 0) {
              // Zero marks the end of input; we have all the numbers.
			   break;
		   }
		   numbers[count] = num;  // Put num in position count.
		   count++;  // Count the number
	   }
  
	   
	   System.out.println("Your numbers in reverse order are:");
	   for ( i = count - 1; i >= 0; i-- ) 
	   {
		   System.out.println( numbers[i] );
	   }
     
   	} // end main();
   
}  // end class ReverseInputNumbers

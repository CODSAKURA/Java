package MyAnswer;

import textio.TextIO;

/**This program convert the user input(hexadecimal digits) to base-10 equivalent.
 *  And then print it out. If the user has not inputted a valid value, then the program
 *  prints a error message to the user.
 * */

public class Main {

	/**Converting a hexadecimal digit to a base-10 value and return that value.
	 * If the digit is not a hexadecimal, then return -1.
	 * @param c the character that is needed to be converted to a hexadecimal value.
	 * @return the hexadecimal value that is corresponding to a hexadecimal digit.
	 * 			If it is not a valid hexadecimal digit, then return -1.
	 * */
	static int hexValue( char c )
	{
		switch( c ) {
			case '0' -> { return 0; }
			case '1' -> { return 1; }
			case '2' -> { return 2; }
			case '3' -> { return 3; }
			case '4' -> { return 4; }
			case '5' -> { return 5; }
			case '6' -> { return 6; }
			case '7' -> { return 7; }
			case '8' -> { return 8; }
			case '9' -> { return 9; }
			case 'A' , 'a' -> { return 10; }	//Handling both Upper case and Lower case
			case 'B' , 'b' -> { return 11; }
			case 'C' , 'c' -> { return 12; }
			case 'D' , 'd' -> { return 13; }
			case 'E' , 'e' -> { return 14; }
			case 'F' , 'f' -> { return 15; }
			default -> { return -1; }
		}
	}
	
	public static void main(String[] args) {
		
		TextIO.put("Enter a string:");
		String str = TextIO.getln();	//Obtain the user input
		
		int value = 0;
		for ( int i = 0; i < str.length();  i++ )
		{
			/*Checking each character of user input is whether a valid hexadecimal digit or not
			 * If not, then immediately quit the program.
			 * */
			if(hexValue( str.charAt(i) ) < 0)
			{
				System.out.println("All the characters in your input string must be hexadecimal digits!!!");
				System.out.println("Try Again!!!");
				System.exit(0);
			}
			value = value*16 + hexValue( str.charAt(i) );
		}
		
		System.out.println("Value:" + value);
	}

}
